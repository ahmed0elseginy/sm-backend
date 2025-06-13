package zag.sm.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.post.model.generated.CommentReactions;
import zag.sm.post.repository.entity.CommentReaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentReactJPARepo extends JpaRepository<CommentReaction, Long> {

    @Query("SELECT COUNT(*) FROM CommentReaction cr WHERE cr.comment.id = :commentId AND cr.react=:react")
    Long reactCount(@Param("commentId") long commentId, @Param("react") CommentReactions react);

    Optional<CommentReaction> findByCommentIdAndCreatedById(Long commentId,Long userId);

    List<CommentReaction> findByCommentId(Long commentId);

}
