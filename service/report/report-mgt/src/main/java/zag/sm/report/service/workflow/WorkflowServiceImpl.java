package zag.sm.report.service.workflow;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.repository.entity.workflow.WorkflowAction;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.repository.entity.workflow.WorkflowTransition;
import zag.sm.report.repository.jpa.workflow.*;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {
    private final ActionService actionService;
    private final TransitionService transitionService;
    private final RequestService requestService;
    private final ActivityService activityService;

    @Override
    public WorkflowRequest processRequest(int workflowId, Long postId, ReportRequestDTO reportRequestDTO) {

        WorkflowAction initialAction = actionService.findInitialAction(workflowId);

        List<WorkflowTransition> eligibleTransition = transitionService.findEligibleTransitions(workflowId, initialAction.getId());

        //*********** eligibleTransition is a list ****************
        WorkflowRequest request = requestService.createRequest(workflowId, eligibleTransition.get(0));

        List<WorkflowActivity> activities = activityService.findTransitionActivity(workflowId, eligibleTransition.get(0).getId());

        WorkflowRequest request1 = activityService.executeActivity(request, activities, postId, reportRequestDTO);

        WorkflowRequest updatedRequest = requestService.updateRequest(request1, eligibleTransition.get(0));

        return updatedRequest;

    }

}

