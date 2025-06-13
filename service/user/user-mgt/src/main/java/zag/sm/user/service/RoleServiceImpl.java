package zag.sm.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.sm.user.repository.entity.Role;
import zag.sm.user.repository.entity.User;
import zag.sm.user.repository.entity.UserRole;
import zag.sm.user.repository.jpa.RoleJPARepository;
import zag.sm.user.repository.jpa.UserJPARepository;
import zag.sm.user.repository.jpa.UserRoleJPARepository;

import static zag.sm.user.model.enums.UserErrors.ROLE_NOT_FOUND;
import static zag.sm.user.model.enums.UserErrors.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final UserJPARepository userRepository;
    private final RoleJPARepository roleRepository;
    private final UserRoleJPARepository userRoleRepository;

    @Override
    public void assignRoleToUser(Long UserId, Integer roleId) {
        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new BusinessException(ROLE_NOT_FOUND));
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRole(role);
        userRoleRepository.save(userRole);
    }

    @Override
    public void removeRoleFromUser(Long UserId, Integer roleId) {
        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new BusinessException(ROLE_NOT_FOUND));
        UserRole userRole = userRoleRepository.findByUserIdAndRoleId(user.getId(), role.getId());
        if (userRole!= null) {
            userRoleRepository.delete(userRole);
        }
    }
}
