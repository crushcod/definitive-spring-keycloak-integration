package com.crushoncode.web.authentication.filter;

import com.crushoncode.web.authentication.service.PathService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
@Slf4j
public class SecurityFilter implements Filter {

    private final PathService pathService;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public SecurityFilter( PathService pathService) {
        this.pathService = pathService;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        KeycloakSecurityContext keycloakSecurityContext =
                (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
    }
}
