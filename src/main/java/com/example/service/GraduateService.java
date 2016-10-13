package com.example.service;

import com.example.mapper.GraduateMapper;
import com.example.model.Graduate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GraduateService {
    private GraduateMapper graduateMapper;

    @Autowired
    public GraduateService(GraduateMapper graduateMapper) {
        this.graduateMapper = graduateMapper;
    }

    @Transactional(readOnly = true)
    public List<Graduate> findAll(){
        return graduateMapper.findAll();
    }

    @Transactional(readOnly = true)
    public void insert(Graduate graduate) {
        graduateMapper.insert(graduate);
    }
}
