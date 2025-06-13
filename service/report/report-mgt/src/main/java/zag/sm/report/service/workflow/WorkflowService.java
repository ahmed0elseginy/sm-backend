package zag.sm.report.service.workflow;

import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;

public interface WorkflowService {

    WorkflowRequest processRequest(int workflowId, Long postId, ReportRequestDTO reportRequestDTO);
}
