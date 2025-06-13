package zag.sm.report.repository.entity.workflow;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wf_action")
public class WorkflowAction {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "title_en")
    private String title;

    @ManyToMany(mappedBy = "actions")
    @JsonIgnore
    private List<WorkflowTransition> transitions;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;


}
