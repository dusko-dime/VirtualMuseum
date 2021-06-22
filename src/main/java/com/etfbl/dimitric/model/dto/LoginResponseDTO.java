package com.etfbl.dimitric.model.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String accessToken;
    private String refreshToken;
    private UserLoginResponseDTO user;
}