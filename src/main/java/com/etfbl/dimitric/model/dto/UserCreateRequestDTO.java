package com.etfbl.dimitric.model.dto;

import lombok.Data;

@Data
public class UserCreateRequestDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
