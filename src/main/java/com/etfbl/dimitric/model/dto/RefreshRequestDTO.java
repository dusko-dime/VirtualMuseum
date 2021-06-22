package com.etfbl.dimitric.model.dto;

import lombok.Data;

@Data
public class RefreshRequestDTO {
    private String accessToken;
    private String refreshToken;
}
