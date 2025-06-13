package zag.sm.report.service.workflow;

import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.repository.entity.workflow.WorkflowTransition;

public interface RequestService {

    WorkflowRequest createRequest(int workflowId, WorkflowTransition transition);
    WorkflowRequest updateRequest(WorkflowRequest request, WorkflowTransition transition);


}
