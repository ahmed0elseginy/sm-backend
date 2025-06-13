package zag.library.security.core.service.filter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import zag.library.security.api.model.enums.SecurityErrors;
import zag.library.security.api.model.exception.AuthorizationException;
import zag.library.security.api.service.JWTService;
import zag.library.security.api.service.filter.JWTFilterService;
import zag.library.security.core.mapper.SecurityMapper;
import zag.library.security.core.model.vto.SecurityUserVTO;
import zag.library.session.api.service.RequestContext;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.*;

@AllArgsConstructor
@Service("RESTJWTFilterService")
public class RESTJWTFilterService implements JWTFilterService {
    private final RequestContext requestContext;
    private final JWTService jwtService;
    private final UserDetailsService userDetailsService;
    private final SecurityMapper mapper;

    @Override
    public void filterService(Object... args) {
        HttpServletRequest request = (HttpServletRequest) args[0];
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null)
            return;
        else if (!authorizationHeader.startsWith("Bearer "))
            throw new AuthorizationException(SecurityErrors.MISSING_TOKEN);

        String token = authorizationHeader.replace("Bearer ", "");

        requestContext.put(USER_TOKEN, token);
        String username = jwtService.extractUserName(token);
        requestContext.put(USERNAME, username);

        Long userId = ((Integer) jwtService.extractClaim(token, USER_ID.label())).longValue();
        requestContext.put(USER_ID, userId);

        if (username == null)
            throw new AuthorizationException(SecurityErrors.MISSING_USERNAME);

        SecurityUserVTO userDetails = (SecurityUserVTO) userDetailsService.loadUserByUsername(username);
        if (userDetails == null)
            throw new AuthorizationException(SecurityErrors.TOKEN_USER_NOT_FOUND);

        Boolean isValid = jwtService.validateToken(token, userDetails);

        if (!isValid)
            throw new AuthorizationException(SecurityErrors.INVALID_TOKEN);
        UsernamePasswordAuthenticationToken authToken = mapper.toUser(userDetails);
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

//        requestContext.put(USER_EMAIL, userDetails.getEmail());
//        requestContext.put(USER_MOBILE, userDetails.getMobileNumber());
    }

}
