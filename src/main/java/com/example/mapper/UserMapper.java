package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findByUserName(String username);

    int insertUser(User user);

    void insertCompanyRole(String username);

    void insertGraduateRole(String username);

    List<User> findAll();

    void insertAdminRole(String username);

    void delUserById(Integer id);

    void delRoleByUserId(Integer id);

}
