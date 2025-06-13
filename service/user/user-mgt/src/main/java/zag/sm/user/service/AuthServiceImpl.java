package zag.sm.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zag.library.error.exception.BusinessException;
import zag.library.security.api.service.JWTService;
import zag.library.security.api.service.SecurityService;
import zag.library.session.api.service.RequestContext;
import zag.sm.user.mapper.UserMapper;
import zag.sm.user.model.generated.CreateUserDTO;
import zag.sm.user.model.generated.LoginUserDTO;
import zag.sm.user.model.generated.LoginUserVTO;
import zag.sm.user.repository.entity.Role;
import zag.sm.user.repository.entity.User;
import zag.sm.user.repository.entity.UserRole;
import zag.sm.user.repository.jpa.RoleJPARepository;
import zag.sm.user.repository.jpa.UserJPARepository;
import zag.sm.user.repository.jpa.UserRoleJPARepository;
import org.springframework.jms.core.JmsTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static zag.library.security.api.model.enums.SecurityErrors.INVALID_CREDENTIALS;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.ROLES_IDS;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.user.model.enums.UserErrors.*;
import static zag.sm.user.model.enums.UserRoles.MEMBER;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final SecurityService securityService;
    private final JWTService jwtService;
    private final UserJPARepository userRepository;
    private final RoleJPARepository roleRepository;
    private final UserRoleJPARepository userRoleRepository;
    private final UserMapper mapper;
    private final RequestContext context;

    private final UserDetailsService userDetailsService;
    private final JmsTemplate jmsTemplate;

    @Override
    public LoginUserVTO login(LoginUserDTO dto) {
        //SecurityUserVTO user = (SecurityUserVTO) userDetailsService.loadUserByUsername(dto.getUsername());
        User user=userRepository.findByEmail(dto.getUsername());
        if (user == null)
            throw new BusinessException(INVALID_CREDENTIALS);
        else {
            boolean isPasswordMatch = securityService.comparePasswords(dto.getPassword(), user.getPassword());
            if (!isPasswordMatch)
                throw new BusinessException(INVALID_CREDENTIALS);
        }

        List<UserRole> roles = userRoleRepository.findAllByUserId(user.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put(USER_ID.name(), user.getId());
        claims.put(ROLES_IDS.name(), roles.stream().map(UserRole::getRole).map(Role::getId).toList());
        String token = jwtService.generateToken(dto.getUsername(), claims);

        return LoginUserVTO.builder().token(token).build();
    }

    @Override
    @Transactional
    public void registerUser(CreateUserDTO dto) {
        User _user = userRepository.findByEmail(dto.getEmail());
        if (_user != null)
            throw new BusinessException(EMAIL_ALREADY_EXIST);

        Role role = roleRepository.findById(MEMBER.getId()).or(() -> {
            throw new BusinessException(ROLE_NOT_FOUND);
        }).get();

        User user = mapper.toUser(dto);
        user.evaluateStatus();
        user = userRepository.save(user);

        user.setCreatedBy(user);
        userRepository.save(user);

        UserRole userRole = UserRole.builder().role(role).userId(user.getId()).build();
        userRoleRepository.saveAndFlush(userRole);

//        jmsTemplate.convertAndSend(
//                UserDomains.REGISTER.destination(),
//                userMapper.toUserEventData(post),
//                message -> {
//                    message.setStringProperty(EVENT_NAME.mqHeader(), REGISTER.name());
//                    return message;
//                });

    }
}
