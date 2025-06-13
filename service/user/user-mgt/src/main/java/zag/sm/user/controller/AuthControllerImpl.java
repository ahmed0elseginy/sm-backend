package zag.sm.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.user.controller.generated.AuthController;
import zag.sm.user.model.generated.CreateUserDTO;
import zag.sm.user.model.generated.LoginUserDTO;
import zag.sm.user.model.generated.LoginUserVTO;
import zag.sm.user.service.AuthService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService service;

    @Override
    public ResponseEntity<LoginUserVTO> _login(LoginUserDTO loginUserDTO) {
        LoginUserVTO res = service.login(loginUserDTO);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<Void> _registerUser(CreateUserDTO createUserDTO) {
        service.registerUser(createUserDTO);
        return ResponseEntity.status(CREATED).build();
    }
}
