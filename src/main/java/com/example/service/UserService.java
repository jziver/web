package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void addCompanyUser(User user){
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        userMapper.insertCompanyRole(user.getUsername());
    }

    @Transactional
    public void addAdminUser(User user){
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        userMapper.insertAdminRole(user.getUsername());
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
