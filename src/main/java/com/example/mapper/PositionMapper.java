package com.example.mapper;

import com.example.model.Position;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PositionMapper {
    void insert(Position position);
    void delByMajorId(Integer id);
}
