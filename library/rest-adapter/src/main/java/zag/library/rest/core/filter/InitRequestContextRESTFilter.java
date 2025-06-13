package zag.library.rest.core.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import zag.library.session.api.service.RequestContext;

import java.io.IOException;
import java.util.Enumeration;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.*;

@Component
@AllArgsConstructor
@Log4j2
public class InitRequestContextRESTFilter extends OncePerRequestFilter {
    private final RequestContext requestContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            String value = request.getHeader(header);
            log.debug("Header: " + header + " = " + request.getHeader(header));
            switch (header) {
                case HttpHeaders.ACCEPT_LANGUAGE -> requestContext.put(LANGUAGE, value);
                case HttpHeaders.USER_AGENT -> requestContext.put(USER_AGENT, value);
                case HttpHeaders.AUTHORIZATION -> {
                    String jwt = value.replace("Bearer ", "").split("\\.")[1];
                    requestContext.put(USER_TOKEN, jwt);
                }
            }
        }
        String apiPath = request.getRequestURI();
        requestContext.put(REQUEST_TYPE, "REST");
        requestContext.put(REQUEST_DESTINATION, apiPath);
        filterChain.doFilter(request, response);
    }
}
