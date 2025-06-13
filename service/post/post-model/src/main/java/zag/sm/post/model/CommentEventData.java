package zag.sm.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEventData implements Serializable {

    private Long id;
    private PostEventData post;
    private String content;
    private Date createdOn;
    private Long createdById;


}

