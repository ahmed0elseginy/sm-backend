package zag.sm.report.service.workflow;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.sm.report.repository.entity.workflow.Workflow;
import zag.sm.report.repository.entity.workflow.WorkflowAction;
import zag.sm.report.repository.jpa.workflow.WorkflowActionRepository;
import zag.sm.report.repository.jpa.workflow.WorkflowRepository;

@Service
@AllArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final WorkflowActionRepository actionRepo;
    private final WorkflowRepository workflowRepo;

    @Override
    public WorkflowAction findInitialAction(int workflowId) {

        Workflow workflow = workflowRepo.findById(workflowId).orElseThrow(
                () -> new RuntimeException("This Workflow Not Found")
        );

        return actionRepo.findInitialActionByWorkflowId(workflowId);
    }

}
