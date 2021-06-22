package com.etfbl.dimitric.model.dto;

import lombok.Data;

@Data
public class RefreshResponseDTO {
    private String accessToken;
    private String refreshToken;
}
