package com.etfbl.dimitric.controller;

import com.etfbl.dimitric.exceptions.HttpException;
import com.etfbl.dimitric.model.dto.LoginRequestDTO;
import com.etfbl.dimitric.model.dto.LoginResponseDTO;
import com.etfbl.dimitric.model.dto.RefreshRequestDTO;
import com.etfbl.dimitric.model.dto.RefreshResponseDTO;
import com.etfbl.dimitric.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login( @RequestBody LoginRequestDTO loginRequest) throws HttpException {
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/refresh")
    public RefreshResponseDTO refresh( @RequestBody RefreshRequestDTO refreshRequest) {
        return authService.refresh(refreshRequest.getAccessToken(), refreshRequest.getRefreshToken());
    }
}
