package zag.sm.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class PostEventData implements Serializable {

    private Long id;
    private String title;
    private String content;
    private Date createdOn;
    private Date lastModifiedOn;
    private Long createdById;
    private Boolean isDeleted ;


}
