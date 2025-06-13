package zag.sm.post.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.library.session.api.service.RequestContext;
import zag.sm.post.mapper.PostMapper;
import zag.sm.post.model.entity.CommentWithReaction;
import zag.sm.post.model.enums.PostDomains;
import zag.sm.post.repository.entity.Comment;
import zag.sm.post.repository.entity.CommentReaction;
import zag.sm.post.repository.entity.Post;
import zag.sm.post.repository.jpa.CommentJPARepository;
import zag.sm.post.repository.jpa.CommentReactJPARepo;
import zag.sm.post.model.generated.*;

import java.util.List;

import static zag.library.common.enums.AppHeaders.EVENT_NAME;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.post.model.enums.CommentEvents.CREATE_COMMENT;
import static zag.sm.post.model.enums.CommentEvents.DELETE_COMMENT;
import static zag.sm.post.model.enums.PostErrors.*;
import static zag.sm.post.model.enums.PostEvents.CREATE_POST;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentJPARepository commentRepository;
    private final CommentReactJPARepo reactRepository;
    private final UserService userService;
    private final PostMapper postMapper;
    private final PostService postService;
    private final RequestContext context;
    private final JmsTemplate jmsTemplate;

    @Override
    public Long createComment(Long postId, CommentDTO commentDTO) {
        Post post = postService.getPostById(postId);
        Comment comment = postMapper.toComment(commentDTO, post);
        Comment commentSaved=commentRepository.save(comment);

        System.out.println(postMapper.toCommentEventData(comment));

        jmsTemplate.convertAndSend(
                PostDomains.COMMENT.destination(),
                postMapper.toCommentEventData(comment),
                message -> {
                    message.setStringProperty(EVENT_NAME.mqHeader(), CREATE_COMMENT.name());
                    return message;
                });

        return commentSaved.getId();

    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Long currentUserId = context.get(USER_ID, Long.class);

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessException(COMMENT_NOT_FOUND));

        List<CommentReaction> reaction= reactRepository.findByCommentId(commentId);

        if(!comment.getCreatedById().equals(currentUserId)){
            throw new BusinessException(IN_CORRECT_USER);
        }
        if(!comment.getPost().getId().equals(postId)){
            throw new BusinessException(IN_CORRECT_POST);
        }
        if(!reaction.isEmpty()){
            reactRepository.deleteAll(reaction);
        }
        commentRepository.delete(comment);

        jmsTemplate.convertAndSend(
                PostDomains.COMMENT.destination(),
                postMapper.toCommentEventData(comment),
                message -> {
                    message.setStringProperty(EVENT_NAME.mqHeader(), DELETE_COMMENT.name());
                    return message;
                });

    }

    @Override
    public CommentResultSet getComments(Long postId, Integer pageOffset, Integer pageSize) {

       Long currentUserId= context.get(USER_ID, Long.class);

        Post post=postService.getPostById(postId);

        Pageable pageable = PageRequest.of(pageOffset, pageSize);

        List<CommentWithReaction> commentReactions = commentRepository.findByPostId(postId,currentUserId, pageable);

        System.out.println(commentReactions);

        List<CommentListItem> commentListItem = commentReactions.stream().map(
                commentReaction -> {
                    Comment comment = commentReaction.getComment();
                    Long commentId = comment.getId();
                    LightUserVTO lightUser = userService.getUsersByIds(List.of(comment.getCreatedById())).getData().get(0);
                    long numOfLikes = reactRepository.reactCount(commentId, CommentReactions.LIKE);
                    long numOfDislikes = reactRepository.reactCount(commentId, CommentReactions.DIS_LIKE);
                    return CommentListItem.builder()
                            .id(commentId)
                            .createdBy(lightUser)
                            .content(comment.getContent())
                            .createdOn(comment.getCreatedOn())
                            .currentUserReaction(commentReaction.getReaction() !=null ? commentReaction.getReaction().getReact() : null)
                            .numOfLikes(numOfLikes)
                            .numOfDisLikes(numOfDislikes)
                            .build();
                }
        ).toList();

        return CommentResultSet.builder()
                .data(commentListItem)
                .build();

    }

    @Override
    public Long getAllCommentsCount(Long postId) {
        Post post=postService.getPostById(postId);
        return commentRepository.getCommentsCount(postId);
    }

    public Comment getCommentById(Long commentID) {
        return commentRepository.findById(commentID).orElseThrow(
                () -> new BusinessException(COMMENT_NOT_FOUND)
        );
    }


}
