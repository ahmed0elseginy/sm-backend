package zag.sm.post.service.mq;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.sm.post.repository.entity.Comment;
import zag.sm.post.repository.entity.Post;
import zag.sm.post.repository.jpa.CommentJPARepository;
import zag.sm.post.service.PostService;

import static zag.sm.post.model.enums.PostErrors.COMMENT_NOT_FOUND;


@Service
@AllArgsConstructor
public class CommentMgtListenerServiceImpl implements CommentMgtListenerService {

    private final PostService postService;
    private final CommentJPARepository commentRepository;

    @Override
    public Long createComment(Long postId) {
        Post post = postService.getPostById(postId);

        Comment comment = new Comment();
        comment.setPost(post);

        return commentRepository.save(comment).getId();
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessException(COMMENT_NOT_FOUND));

        commentRepository.delete(comment);
    }
}
