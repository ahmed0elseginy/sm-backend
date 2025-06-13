package zag.sm.post.service;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.library.session.api.service.RequestContext;
import zag.sm.post.mapper.PostMapper;
import zag.sm.post.model.generated.CommentReactions;
import zag.sm.post.model.enums.CommentReactionEvents;
import zag.sm.post.model.enums.PostDomains;
import zag.sm.post.repository.entity.Comment;
import zag.sm.post.repository.entity.CommentReaction;
import zag.sm.post.repository.jpa.CommentReactJPARepo;

import java.util.Optional;

import static zag.library.common.enums.AppHeaders.EVENT_NAME;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.post.model.enums.CommentEvents.CREATE_COMMENT;
import static zag.sm.post.model.enums.CommentReactionEvents.*;
import static zag.sm.post.model.enums.PostErrors.IN_CORRECT_POST;

@AllArgsConstructor
@Service
public class CommentReactServiceImpl implements CommentReactService {

    private final CommentReactJPARepo reactRepo;
    private final CommentService commentService;
    private final RequestContext context;
    private final PostService postService;
    private final PostMapper postMapper;
    private final JmsTemplate jmsTemplate;

    @Override
    public void createReaction(Long postId,Long commentId, CommentReactions react) {
        //userId,commentId,createdOn,react
        Long currentUserId = context.get(USER_ID, Long.class);

        postService.getPostById(postId);   //checking if the post is already exist (user not found)

        Comment comment = commentService.getCommentById(commentId);  //checking if the comment is already exist

        if(comment.getPost().getId() != postId){
            throw new BusinessException(IN_CORRECT_POST);  //(Post Id provided is not the same as the post id in the comment)
        }

        Optional<CommentReaction> reactionComment=reactRepo.findByCommentIdAndCreatedById(commentId,currentUserId);

        if(!reactionComment.isPresent()) {
            CommentReaction reaction = CommentReaction.builder()
                    .createdById(currentUserId)
                    .comment(comment)
                    .react(react)
                    .build();
            reactRepo.save(reaction);

            jmsTemplate.convertAndSend(
                    PostDomains.REACTION.destination(),
                    postMapper.toReactionEventData(reaction),
                    (message) -> {
                        message.setStringProperty(EVENT_NAME.mqHeader(), CREATE_REACTION.name());
                        return message;
                    }
            );

        } else{
            CommentReaction existReaction=reactionComment.get();
            System.out.println(existReaction.getReact());
            if(!existReaction.getReact().equals(react)){
                existReaction.setReact(react);
                reactRepo.save(existReaction);

                jmsTemplate.convertAndSend(
                        PostDomains.REACTION.destination(),
                        postMapper.toReactionEventData(existReaction),
                        (message) -> {
                            message.setStringProperty(EVENT_NAME.mqHeader(), UPDATE_REACTION.name());
                            return message;
                        }
                );

            }else{
                //throw new BusinessException(REACTED_USER_ID);
                reactRepo.delete(existReaction);

                jmsTemplate.convertAndSend(
                        PostDomains.REACTION.destination(),
                        postMapper.toReactionEventData(existReaction),
                        (message) -> {
                            message.setStringProperty(EVENT_NAME.mqHeader(), DELETE_REACTION.name());
                            return message;
                        }
                );

            }

        }

    }
}
