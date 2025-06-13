package zag.sm.report.repository.entity.workflow;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wf_transition")
public class WorkflowTransition {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "from_status_id")
    @JsonIgnore
    private WorkflowStatus fromStatus;

    @ManyToOne
    @JoinColumn(name = "to_status_id")
    @JsonIgnore
    private WorkflowStatus toStatus;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    @JsonIgnore
    private Workflow workflow;

    @ManyToMany
    @JoinTable(
            name = "wf_transition_action",
            joinColumns = @JoinColumn(name = "transition_id"),
            inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    @JsonIgnore
    private List<WorkflowAction> actions;

    @ManyToMany
    @JoinTable(
            name = "wf_transition_condition",
            joinColumns = @JoinColumn(name = "transition_id"),
            inverseJoinColumns = @JoinColumn(name = "condition_id")
    )
    @JsonIgnore
    private List<WorkflowCondition> conditions;


    @ManyToMany
    @JoinTable(
            name = "wf_transition_activity",
            joinColumns = @JoinColumn(name = "transition_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    @JsonIgnore
    private List<WorkflowActivity> activities;


}
