package zag.sm.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportEventData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long postId;
    private Date createdOn;
    private String reason;
    private Date lastModifiedOn;
    private Long lastModifiedById;
    private Long createdById;
    private String rejectReason;
    private Long postOwnerId;



}
