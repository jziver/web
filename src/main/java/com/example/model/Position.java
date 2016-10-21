package com.example.model;

import java.io.Serializable;

/**
 * 职位
 */
public class Position implements Serializable {
    private static final long serialVersionUID = -8895221609134980223L;

    public Position(){}

    public Position(String positionName) {
        this.positionName = positionName;
    }

    private Integer id;
    private String positionName;
    private Long marjorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;

    }

    public Long getMarjorId() {
        return marjorId;
    }

    public Position setMarjorId(Long marjorId) {
        this.marjorId = marjorId;
        return this;
    }
}
