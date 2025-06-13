package zag.sm.post.service;


import zag.sm.post.model.generated.CommentReactions;

public interface CommentReactService {

    void createReaction(Long postId ,Long commentId, CommentReactions react);

}
