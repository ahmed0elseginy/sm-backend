package zag.library.security.core.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import zag.library.security.api.service.filter.JWTFilterService;

import java.io.IOException;

@Component
@AllArgsConstructor
@Log4j2
public class AuthenticationRESTFilter extends OncePerRequestFilter {
    @Qualifier("RESTJWTFilterService")
    private final JWTFilterService filterService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterService.filterService(request, response, filterChain);
        filterChain.doFilter(request, response);
    }
}
