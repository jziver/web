package com.example.service;

import com.example.mapper.CompanyMapper;
import com.example.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    private CompanyMapper companyMapper;

    @Autowired
    public CompanyService(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Transactional
    public void insertCompany(Company company){
        companyMapper.insertCompany(company);
    }

}
