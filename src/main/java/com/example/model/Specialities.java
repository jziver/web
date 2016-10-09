package com.example.model;

import java.io.Serializable;

/**
 * 专业.
 */
public class Specialities implements Serializable{
    private static final long serialVersionUID = 4236356365713921301L;
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
