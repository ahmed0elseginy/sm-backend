package zag.sm.post.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zag.sm.post.repository.entity.Comment;
import zag.sm.post.repository.entity.CommentReaction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentWithReaction {

    private Comment comment;
    private CommentReaction reaction;

}
