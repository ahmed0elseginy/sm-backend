package zag.sm.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.report.controller.generated.AdminReportController;
import zag.sm.report.model.generated.*;
import zag.sm.report.service.AdminService;

import java.util.Date;

import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;


@RestController
@AllArgsConstructor
public class AdminControllerImpl implements AdminReportController {


    private final AdminService adminService;

    @Override
    @Secured(ADMIN_ROLE)
    public ResponseEntity<LightReportResultSet> _getAllReportsByFilters(Integer statusId, Integer categoryId, Date createdOnFrom, Date createdOnTo, OrderByAttributes orderBy, OrderDirections orderDir, Integer pageOffset, Integer pageSize) {
        return ResponseEntity.ok(
                adminService.getAllReportsByFilter(statusId, categoryId,createdOnFrom, createdOnTo, orderBy, orderDir, pageOffset, pageSize)
                );
    }

    @Override
    @Secured(ADMIN_ROLE)
    public ResponseEntity<FullReportDetails> _getReportsDetailsById(Long reportId) {
        return ResponseEntity.ok(adminService.getReportsDetailsById(reportId));
    }

    @Override
    @Secured(ADMIN_ROLE)
    public ResponseEntity<Void> _performAction(Long reportId, ReportActions action, PerformActionRequest performActionRequest) {
        adminService.performReportAction(reportId, action, performActionRequest);
        return ResponseEntity.noContent().build();
    }



}
