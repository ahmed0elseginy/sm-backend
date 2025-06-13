package zag.sm.report.service;


import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;

public interface ReportService {

    WorkflowRequest createPostReport(WorkflowRequest request,Long postId , ReportRequestDTO reportDTO);
    void generateReport(Long postId ,ReportRequestDTO reportDTO);

}
