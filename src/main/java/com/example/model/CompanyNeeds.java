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
    private int needNumber; //需求人数
    private String SalaryRange; //薪资范围
    private Date publishDate; //发布时间
    private Date validityDate;  //过期时间
    private Major major;    //专业
    private boolean needStatus; //是否招满

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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
