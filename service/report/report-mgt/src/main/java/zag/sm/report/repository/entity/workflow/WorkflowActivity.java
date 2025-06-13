package zag.sm.report.repository.entity.workflow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wf_activity")
public class WorkflowActivity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "title_en")
    private String title;

    @Basic
    @Column(name = "class_name")
    private String className;

    @Basic
    @Column(name = "method_name")
    private String methodName;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

    @ManyToMany(mappedBy = "activities")
    @JsonIgnore
    private List<WorkflowTransition> transitions;
}
