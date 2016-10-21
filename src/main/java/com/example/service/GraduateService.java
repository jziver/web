package com.example.service;

import com.example.mapper.GraduateMapper;
import com.example.mapper.UserMapper;
import com.example.model.Graduate;
import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GraduateService {
    private GraduateMapper graduateMapper;
    private UserMapper userMapper;

    @Autowired
    public GraduateService(GraduateMapper graduateMapper, UserMapper userMapper) {
        this.graduateMapper = graduateMapper;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public List<Graduate> findAll(){
        return graduateMapper.findAll();
    }

    @Transactional
    public void insert(Graduate graduate) {
        graduate.getUser().setCreateTime(new Date());
        userMapper.insertUser(graduate.getUser());
        userMapper.insertGraduateRole(graduate.getUser().getUsername());
        graduateMapper.insert(graduate);
    }

    @Transactional(readOnly = true)
    public Graduate findByUserId(Long id) {
        return graduateMapper.findByUserId(id);
    }

    @Transactional
    public void delByUserId(Integer id) {
        //1.删除用户角色表
        userMapper.delRoleByUserId(id);
        //2.删除毕业生表
        graduateMapper.delByUserId(id);
        //3.删除用户表
        userMapper.delUserById(id);
    }
}
