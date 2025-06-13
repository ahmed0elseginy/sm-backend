package zag.sm.post.service;


import zag.sm.post.model.generated.CommentDTO;
import zag.sm.post.model.generated.CommentResultSet;
import zag.sm.post.repository.entity.Comment;

public interface CommentService {


    Long createComment(Long postId, CommentDTO commentDTO);

    CommentResultSet getComments(Long postId, Integer pageOffset, Integer pageSize);

    void deleteComment(Long postId, Long commentId);

    Long getAllCommentsCount(Long postId);

    Comment getCommentById(Long commentId);

}
