package zag.sm.post.service.mq;

public interface CommentMgtListenerService {

    Long createComment(Long postId);

    void deleteComment(Long commentId);

}
