package com.etfbl.dimitric.service;

import com.etfbl.dimitric.model.dto.UserCreateRequestDTO;
import com.etfbl.dimitric.model.dto.UserDTO;

public interface UserService {
    UserDTO insert(UserCreateRequestDTO userCreateRequestDTO);
}
