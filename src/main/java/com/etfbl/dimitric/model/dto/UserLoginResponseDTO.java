package com.etfbl.dimitric.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDTO implements Serializable {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
