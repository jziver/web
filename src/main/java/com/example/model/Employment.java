package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 毕业生就业
 */
public class Employment implements Serializable{
    private static final long serialVersionUID = 9161681069234590290L;
    private Integer id;
    private Date joinDate;
    private Graduate graduate;
    private Company company;
    private Position position;
    private float salary;
    private boolean  leaveJob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Graduate getGraduate() {
        return graduate;
    }

    public void setGraduate(Graduate graduate) {
        this.graduate = graduate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isLeaveJob() {
        return leaveJob;
    }

    public void setLeaveJob(boolean leaveJob) {
        this.leaveJob = leaveJob;
    }
}
