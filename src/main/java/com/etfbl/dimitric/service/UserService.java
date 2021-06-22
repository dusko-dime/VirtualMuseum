package com.etfbl.dimitric.service;

import com.etfbl.dimitric.model.dto.UserCreateRequestDTO;
import com.etfbl.dimitric.model.dto.UserDTO;
import com.etfbl.dimitric.model.entity.User;

public interface UserService {
    UserDTO insert(UserCreateRequestDTO userCreateRequestDTO);
    User getByUsername(String username);
}
