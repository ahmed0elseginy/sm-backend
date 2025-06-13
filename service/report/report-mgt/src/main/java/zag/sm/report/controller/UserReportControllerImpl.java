package zag.sm.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.controller.generated.UserReportController;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.service.ReportService;
import zag.sm.report.service.workflow.ActivityService;
import zag.sm.report.service.workflow.WorkflowService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;
import static zag.sm.user.model.enums.UserRoles.MEMBER_ROLE;


@RestController
@AllArgsConstructor
public class UserReportControllerImpl implements UserReportController {

    private final ReportService reportService;
    private final WorkflowService workflowService;


    @Override
    @Secured({ADMIN_ROLE,MEMBER_ROLE})
    public ResponseEntity<Void> _createReport(Long postId, ReportRequestDTO reportRequestDTO) {
        reportService.generateReport(postId, reportRequestDTO);
        return ResponseEntity.status(CREATED).build();
    }

    @PostMapping("/posts/{postId}/createReport")
    @Secured({ADMIN_ROLE, MEMBER_ROLE})
    public ResponseEntity<WorkflowRequest> createReport(@PathVariable("postId") Long postId,
                                                        @RequestBody ReportRequestDTO reportRequestDTO) {
        return ResponseEntity.ok(workflowService.processRequest(1, postId, reportRequestDTO));
    }


}
