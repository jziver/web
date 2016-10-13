package com.example.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 专业.
 */
public class Major implements Serializable{
    private static final long serialVersionUID = 4236356365713921301L;
    private Long id;
    @NotEmpty
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
