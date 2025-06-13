package zag.sm.report.service.workflow;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.sm.report.repository.entity.workflow.Workflow;
import zag.sm.report.repository.entity.workflow.WorkflowTransition;
import zag.sm.report.repository.jpa.workflow.WorkflowRepository;
import zag.sm.report.repository.jpa.workflow.WorkflowTransitionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TransitionServiceImpl implements TransitionService {

    private final WorkflowRepository workflowRepo;
    private final WorkflowTransitionRepository transitionRepo;

    @Override
    public List<WorkflowTransition> findEligibleTransitions(int workflowId, int actionId) {

        Workflow workflow = workflowRepo.findById(workflowId).orElseThrow(
                () -> new RuntimeException("This Workflow Not Found")
        );

        return transitionRepo.findTransitionByAction(actionId);
    }
}
