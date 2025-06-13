package zag.sm.report.repository.entity.workflow;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wf_request")
public class WorkflowRequest {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "title_en")
    private String title;

    @ManyToOne
    @JoinColumn(name = "current_status_id")
    private WorkflowStatus currentStatus;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

    @Basic
    @Column(name = "created_on")
    private Date createdOn;

    @Basic
    @Column(name = "last_modified_on")
    private Date lastModifiedOn;

    @Basic
    @Column(name = "last_modified_by")
    private Long lastModifiedById;

    @Basic
    @Column(name = "created_by" )
    private Long createdById;

}
