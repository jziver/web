package com.example.service;

import com.example.mapper.CompanyMapper;
import com.example.mapper.UserMapper;
import com.example.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {

    private CompanyMapper companyMapper;
    private UserMapper userMapper;

    @Autowired
    public CompanyService(CompanyMapper companyMapper, UserMapper userMapper) {
        this.companyMapper = companyMapper;
        this.userMapper = userMapper;
    }

    @Transactional
    public void insertCompany(Company company){
        company.getUser().setCreateTime(new Date());
        userMapper.insertUser(company.getUser());
        userMapper.insertCompanyRole(company.getUser().getUsername());
        companyMapper.insertCompany(company);
    }

    @Transactional(readOnly = true)
    public List<Company> findAll(){
        return companyMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Company findByUserId(Long id) {
        return companyMapper.findByUserId(id);
    }

    @Transactional
    public void delByUserId(Integer id) {
        userMapper.delRoleByUserId(id);
        companyMapper.delByUserId(id);
        userMapper.delUserById(id);
    }
}
