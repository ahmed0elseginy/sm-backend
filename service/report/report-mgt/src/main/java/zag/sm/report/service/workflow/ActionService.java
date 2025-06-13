package zag.sm.report.service.workflow;

import zag.sm.report.repository.entity.workflow.WorkflowAction;

public interface ActionService {

    WorkflowAction findInitialAction(int workflowId);


}
