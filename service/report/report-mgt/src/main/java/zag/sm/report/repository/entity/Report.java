package zag.sm.report.repository.entity;

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
@Table(name = "post_report")
public class Report {
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


    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Basic
    @Column(name = "created_on", insertable = false, updatable = false)
    private Date createdOn;


    @Basic
    @Column(name = "last_modified_on", insertable = false)
    private Date lastModifiedOn;

    @Basic
    @Column(name = "last_modified_by_id", insertable = false)
    private Long lastModifiedById;

    @Basic
    @Column(name = "created_by_id" ,updatable = false)
    private Long createdById;

}
