package com.example.mapper;


import com.example.model.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    void insertCompany(Company company);

    List<Company> findAll();

}
