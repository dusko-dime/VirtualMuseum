package com.etfbl.dimitric.model.redis;

import com.etfbl.dimitric.model.dto.UserLoginResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken implements Serializable {
    private String refreshToken;
    private Date expiryDate;
    private UserLoginResponseDTO user;
}
