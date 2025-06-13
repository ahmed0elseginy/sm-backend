package zag.sm.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.user.controller.generated.RoleController;
import zag.sm.user.service.RoleService;

import static org.springframework.http.HttpStatus.CREATED;
import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;


@RestController
@AllArgsConstructor
public class RoleControllerImpl implements RoleController {
    private final RoleService roleService;

    @Override
    @Secured({ADMIN_ROLE})
    public ResponseEntity<Void> _assignRoleToUser(Long userId, Integer roleId) {
        roleService.assignRoleToUser(userId,roleId);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    @Secured({ADMIN_ROLE})
    public ResponseEntity<Void> _removeRoleFromUser(Long userId, Integer roleId) {
        roleService.removeRoleFromUser(userId, roleId);
        return ResponseEntity.noContent().build();
    }
}
