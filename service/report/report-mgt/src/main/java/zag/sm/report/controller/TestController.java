package zag.sm.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;
import zag.sm.report.service.workflow.ActivityService;

import java.util.List;

import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;
import static zag.sm.user.model.enums.UserRoles.MEMBER_ROLE;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final ActivityService activityService;

    @Secured({ADMIN_ROLE,MEMBER_ROLE})
    @PostMapping("/createReport")
    public ResponseEntity<List<WorkflowActivity>> createReport() {
        return ResponseEntity.ok(activityService.findTransitionActivity(1, 1));
    }







}
