package zag.sm.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.user.controller.generated.UserController;
import zag.sm.user.model.generated.UserResultSet;
import zag.sm.user.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResultSet> _getUsersByIds(List<Long> ids, String fullName, Integer pageNum, Integer pageSize) {
        return ResponseEntity.ok(userService.getUsers(ids,fullName,pageNum,pageSize));
    }
}
