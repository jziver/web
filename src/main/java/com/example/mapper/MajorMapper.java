package com.example.mapper;

import com.example.model.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {
    List<Major> findAll();
    void insert(Major major);
    void update(Major major);
    void deleteOne(Integer id);
}
