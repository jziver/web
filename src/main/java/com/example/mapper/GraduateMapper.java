package com.example.mapper;

import com.example.model.Graduate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GraduateMapper {
    List<Graduate> findAll();

    void insert(Graduate graduate);
}
