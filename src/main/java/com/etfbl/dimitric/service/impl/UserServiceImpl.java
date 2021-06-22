package com.etfbl.dimitric.service.impl;

import com.etfbl.dimitric.exceptions.NotFoundException;
import com.etfbl.dimitric.model.dto.UserCreateRequestDTO;
import com.etfbl.dimitric.model.dto.UserDTO;
import com.etfbl.dimitric.model.entity.User;
import com.etfbl.dimitric.repository.UserRepository;
import com.etfbl.dimitric.service.UserService;
import com.etfbl.dimitric.util.EmailSender;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Environment environment;
    private final EmailSender emailSender;

    public UserServiceImpl(UserRepository userRepository, EmailSender emailSender, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, Environment environment) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.environment = environment;
        this.emailSender = emailSender;
    }

    @Override
    public UserDTO insert(UserCreateRequestDTO userCreateRequestDTO) {

        User user = modelMapper.map(userCreateRequestDTO, User.class);
        user.setPassword(bCryptPasswordEncoder.encode(userCreateRequestDTO.getPassword()));
        User savedUser = userRepository.saveAndFlush(user);

        String mailBody = environment.getProperty("register.welcome.message");
        if (mailBody == null) {
            mailBody = "Welcome {username}!";
        }

        mailBody = mailBody.replace("{username}", user.getUsername()).replace("{appLink}", environment.getProperty("website.url"));

        emailSender.sendMimeMessage(user.getEmail(), "Welcome", mailBody);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public User getByUsername(String username) {
        User user = userRepository.getByUsernameAndActive(username, (byte)1);
        if(user != null) {
            return user;
        } else {
            throw new NotFoundException();
        }
    }
}
