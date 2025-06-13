package zag.sm.report.service.workflow;

import zag.sm.report.repository.entity.workflow.WorkflowTransition;

import java.util.List;

public interface TransitionService{

    List<WorkflowTransition>findEligibleTransitions(int workflowId,int actionId);

}
