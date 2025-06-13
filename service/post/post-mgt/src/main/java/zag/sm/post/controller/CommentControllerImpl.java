package zag.sm.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.post.controller.generated.CommentController;

import zag.sm.post.model.generated.CommentDTO;
import zag.sm.post.model.generated.CommentReactions;
import zag.sm.post.model.generated.CommentResultSet;
import zag.sm.post.service.CommentReactService;
import zag.sm.post.service.CommentService;

import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;
import static zag.sm.user.model.enums.UserRoles.MEMBER_ROLE;


@AllArgsConstructor
@RestController
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;
    private final CommentReactService commentReactService;


    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Long> _createComment(Long postId, CommentDTO commentDTO) {
        Long createdCommentId = commentService.createComment(postId, commentDTO);
        return ResponseEntity.ok(createdCommentId);
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Void> _deleteComment(Long postId, Long commentId) {
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<CommentResultSet> _getAllComments(Long postId, Integer pageOffset, Integer pageSize) {
        return ResponseEntity.ok(commentService.getComments(postId, pageOffset, pageSize));
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Long> _getAllCommentsCount(Long postId) {
        return ResponseEntity.ok(commentService.getAllCommentsCount(postId));
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Void> _reactComment(Long postId, Long commentId, CommentReactions reaction) {
        commentReactService.createReaction(postId, commentId, reaction);
        return ResponseEntity.noContent().build();
    }

}
