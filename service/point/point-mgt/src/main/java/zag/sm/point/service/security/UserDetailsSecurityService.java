package zag.sm.point.service.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zag.library.security.api.service.JWTService;
import zag.library.security.core.model.vto.SecurityAuthorityVTO;
import zag.library.security.core.model.vto.SecurityUserVTO;
import zag.library.session.api.service.RequestContext;

import java.util.List;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.ROLES_IDS;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_TOKEN;


@Service
@AllArgsConstructor
public class UserDetailsSecurityService implements UserDetailsService {

    private final RequestContext context;
    private final JWTService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String token = context.get(USER_TOKEN);
        List<Integer> roleIds =(List<Integer>) jwtService.extractClaim(token, ROLES_IDS.label());


        SecurityUserVTO userDetails = new SecurityUserVTO();
        userDetails.setUsername(username);



        List<SecurityAuthorityVTO> authorities = roleIds.stream().map(roleId ->
                SecurityAuthorityVTO.builder().role(roleId.toString()).build()).toList();

        userDetails.setAuthorities(authorities);
        return userDetails;
    }
}
