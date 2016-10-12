package com.example.service;

import com.example.mapper.GraduateMapper;
import com.example.model.Graduate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateService {
    private GraduateMapper graduateMapper;

    @Autowired
    public GraduateService(GraduateMapper graduateMapper) {
        this.graduateMapper = graduateMapper;
    }

    public List<Graduate> findAll(){
        return graduateMapper.findAll();
    }
}
