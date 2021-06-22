package com.etfbl.dimitric.service;

import com.etfbl.dimitric.model.dto.LoginResponseDTO;
import com.etfbl.dimitric.model.dto.RefreshResponseDTO;

public interface AuthService {
    LoginResponseDTO login(String username, String password);
    RefreshResponseDTO refresh(String accessToken, String refreshToken);
    void logout(String accessToken);
}
