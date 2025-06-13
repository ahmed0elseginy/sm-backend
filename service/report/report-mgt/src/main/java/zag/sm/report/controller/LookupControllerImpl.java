package zag.sm.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.report.controller.generated.LookupController;
import zag.sm.report.model.generated.LookupResultSet;
import zag.sm.report.service.LookupSerivce;

import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;
import static zag.sm.user.model.enums.UserRoles.MEMBER_ROLE;


@RestController
@AllArgsConstructor
public class LookupControllerImpl implements LookupController {

    private final LookupSerivce lookupSerivce;

    @Override
    @Secured({ADMIN_ROLE,MEMBER_ROLE})
    public ResponseEntity<LookupResultSet> _getAllCategories() {
        return ResponseEntity.ok(lookupSerivce.getCategories());
    }

    @Override
    @Secured(ADMIN_ROLE)
    public ResponseEntity<LookupResultSet> _getAllStatus() {
        return ResponseEntity.ok(lookupSerivce.getStatues());
    }

    
}
