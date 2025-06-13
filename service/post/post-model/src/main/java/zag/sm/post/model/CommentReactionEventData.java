package zag.sm.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import zag.sm.post.model.enums.CommentReactions;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class CommentReactionEventData implements Serializable {

    private Long id;
    private CommentEventData comment;
    private Date createdOn;
    private Long createdById;
    private CommentReactions react;



}
