package zag.sm.report.service.workflow;

import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;

import java.util.List;

public interface ActivityService {

    List<WorkflowActivity> findTransitionActivity(int workflowId,int transitionId);
    WorkflowRequest executeActivity(WorkflowRequest request, List<WorkflowActivity> activity, Long postId,ReportRequestDTO reportRequestDTO);

}
