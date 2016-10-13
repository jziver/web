package com.example.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 企业基本信息表
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 5841391625539590625L;

    private Long id;
    @NotEmpty
    private String address;
    @NotEmpty
    private String companyname;
    @NotEmpty
    private String telephone;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", companyname='" + companyname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", user=" + user +
                '}';
    }
}
