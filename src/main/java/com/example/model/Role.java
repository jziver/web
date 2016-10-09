package com.example.model;

import java.io.Serializable;

/**
 * 用户角色
 * ------------------------
 * ROLE_SU      超级管理员  id=1
 * ROLE_ADMIN   操作员     id=2
 * ROLE_COM     企业       id=3
 * ROLE_GDE     毕业生     id=4
 * ------------------------
 * ROLE_SU > ROLE_ADMIN > ROLE_COM = ROLE_GDE
 */
public class Role implements Serializable{
    private static final long serialVersionUID = -5316300024305721280L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
