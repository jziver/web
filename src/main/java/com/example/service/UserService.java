package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;


    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Transactional
    public void addCompanyUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        userMapper.insertCompanyRole(user.getUsername());
    }

    @Transactional
    public void addAdminUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        userMapper.insertAdminRole(user.getUsername());
    }


    @Transactional
    public void addGraduateUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        userMapper.insertGraduateRole(user.getUsername());
    }

    @Transactional
    public void delUser(Integer id) {

        userMapper.delUserById(id);
    }


    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userMapper.findByUserName(username);
    }

    @PreAuthorize("hasRole('SU')")
    @Transactional
    public void delAdminUser(Integer id) {
        userMapper.delUserById(id);
    }
}
