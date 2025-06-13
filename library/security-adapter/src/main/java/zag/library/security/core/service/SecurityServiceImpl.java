package zag.library.security.core.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zag.library.security.api.service.SecurityService;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public Boolean comparePasswords(String unHashedPassword, String hashedPassword) {
        return passwordEncoder.matches(unHashedPassword, hashedPassword);
    }
}
