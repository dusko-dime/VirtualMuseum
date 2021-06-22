package com.etfbl.dimitric.controller;

import com.etfbl.dimitric.model.dto.UserCreateRequestDTO;
import com.etfbl.dimitric.model.dto.UserDTO;
import com.etfbl.dimitric.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO insert(@RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        return userService.insert(userCreateRequestDTO);
    }

}
