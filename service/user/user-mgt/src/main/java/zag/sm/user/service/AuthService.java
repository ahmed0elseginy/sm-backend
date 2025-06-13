package zag.sm.user.service;

import zag.sm.user.model.generated.CreateUserDTO;
import zag.sm.user.model.generated.LoginUserDTO;
import zag.sm.user.model.generated.LoginUserVTO;

public interface AuthService {
    LoginUserVTO login(LoginUserDTO dto);

    void registerUser(CreateUserDTO dto);
}
