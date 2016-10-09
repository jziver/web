package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUserName(String username);

    void insertUser(User user);

    void insertCompanyRole(String username);

    void insertGraduateRole(String username);

}
