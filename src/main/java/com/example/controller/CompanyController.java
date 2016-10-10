package com.example.controller;

import com.example.model.Company;
import com.example.model.User;
import com.example.service.CompanyService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@Controller
public class CompanyController {

    private UserService userService;
    private CompanyService companyService;

    @Autowired
    public CompanyController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @RequestMapping(value = "/inputCompany",method = RequestMethod.GET)
    public String getInputForm(){
        return "companyInput";
    }

    @RequestMapping(value = "/inputCompany",method = RequestMethod.POST)
    public String inputCompany(@Valid User user, Errors userErrors, Company company){
        if(userErrors.hasErrors()){

            return "companyInput";
        }
        userService.addCompanyUser(user);
        companyService.insertCompany(company);
        return "redirect:/login";
    }


}
