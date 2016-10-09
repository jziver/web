package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void addCompanyUser(User user){
        userMapper.insertUser(user);
        userMapper.insertCompanyRole(user.getUsername());
    }
}
