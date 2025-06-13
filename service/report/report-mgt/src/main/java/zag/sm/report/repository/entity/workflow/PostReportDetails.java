package zag.sm.report.repository.entity.workflow;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zag.sm.report.repository.entity.Category;
import zag.sm.report.repository.entity.Status;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_report_details")
public class PostReportDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "post_id",updatable = false)
    private Long postId;

    @ManyToOne
    @JoinColumn (name = "category_id", updatable = false)
    private Category category;

    @Basic
    @Column(name = "reject_reason", insertable = false)
    private String rejectReason;

    @Basic
    @Column(name = "reason")
    private String reason;

    @OneToOne
    @JoinColumn(name = "wf_request_id")
    private WorkflowRequest request;

}
