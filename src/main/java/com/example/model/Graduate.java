package com.example.model;

import java.io.Serializable;

/**
 * 毕业生基本信息
 */
public class Graduate implements Serializable{
    private static final long serialVersionUID = 5270477921528347379L;
    private Long id;
    private String name;
    private String sex;
    private String phone;
    private Specialities specialities;
    private String clazz; //班级
    private String remark; //备注
    private boolean jobStatus; //求职状态

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Specialities getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Specialities specialities) {
        this.specialities = specialities;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(boolean jobStatus) {
        this.jobStatus = jobStatus;
    }
}
