package com.etfbl.dimitric.security.service.impl;

import com.etfbl.dimitric.model.entity.User;
import com.etfbl.dimitric.repository.UserRepository;
import com.etfbl.dimitric.security.model.SecurityUser;
import com.etfbl.dimitric.security.service.UserSecurityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    private UserRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public UserSecurityServiceImpl(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByUsernameAndActive(username, (byte)1);

        if(user == null) throw new UsernameNotFoundException(username);

        return modelMapper.map(user, SecurityUser.class);
    }
}