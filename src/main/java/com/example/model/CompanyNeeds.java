package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司人才需求
 */
public class CompanyNeeds implements Serializable{
    private static final long serialVersionUID = 1542776504089256093L;

    private Long id;
    private Company company;
    private Position position;
    private int needNumber;
    private String SalaryRange;
    private Date validityDate;
    private Major major;
    private boolean needStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(int needNumber) {
        this.needNumber = needNumber;
    }

    public String getSalaryRange() {
        return SalaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        SalaryRange = salaryRange;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public boolean isNeedStatus() {
        return getNeedNumber() == 0;
    }

    public void setNeedStatus(boolean needStatus) {
        this.needStatus = needStatus;
    }
}
