package zag.sm.user.service.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zag.library.security.api.model.exception.AuthorizationException;
import zag.library.security.core.model.vto.SecurityAuthorityVTO;
import zag.library.security.core.model.vto.SecurityUserVTO;
import zag.sm.user.mapper.UserMapper;
import zag.sm.user.repository.entity.User;
import zag.sm.user.repository.entity.UserRole;
import zag.sm.user.repository.jpa.UserJPARepository;
import zag.sm.user.repository.jpa.UserRoleJPARepository;

import java.util.List;

import static zag.library.security.api.model.enums.SecurityErrors.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class  UserDetailsSecurityService implements UserDetailsService {
    private final UserJPARepository userJPARepository;
    private final UserRoleJPARepository userRoleRepository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJPARepository.findByEmail(username);
        if (user == null)
            throw new AuthorizationException(USER_NOT_FOUND);

        SecurityUserVTO userDetails = mapper.toSecurityUserVTO(user);


        List<UserRole> roles = userRoleRepository.findAllByUserId(user.getId());

        List<SecurityAuthorityVTO> authorities = mapper.toSecurityAuthorityVTOList(roles);


        userDetails.setAuthorities(authorities);
        return userDetails;
    }
}
