package zag.sm.report.repository.entity.workflow;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wf_condition")
public class WorkflowCondition {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "title_en")
    private String title;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

    @Basic
    @Column(name = "class_name")
    private String className;

    @Basic
    @Column(name = "method_name")
    private String methodName;

}
