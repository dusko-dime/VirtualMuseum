package com.etfbl.dimitric.security.config;

import com.etfbl.dimitric.service.AuthService;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLogoutHandler implements LogoutHandler {

    private final AuthService authService;
    Environment environment;

    public CustomLogoutHandler(AuthService authService, Environment environment) {
        this.authService = authService;
        this.environment = environment;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String authorizationHeader = request.getHeader(environment.getProperty("authorization.token.header.name"));

        if(authorizationHeader == null || !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.prefix"))){
            return;
        }

        String accessToken = authorizationHeader.replace(environment.getProperty("authorization.token.header.prefix"), "");

        authService.logout(accessToken.trim());
    }
}
