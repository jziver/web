package com.example.mapper;


import com.example.model.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    void insertCompany(Company company);



}
