package com.example.controller.admin;

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

@Controller
@RequestMapping(value = "/admin")
public class AdminCompanyController {


    private CompanyService companyService;
    private UserService userService;

    @Autowired
    public AdminCompanyController(CompanyService companyService, UserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }


    @RequestMapping(value = "/companyManager", method = RequestMethod.GET)
    public String companyManager(Model model) {
        model.addAttribute("coms", companyService.findAll());
        model.addAttribute("page", "#" + "coms");
        return "admin/home";
    }


    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    public String addCompany(@Valid User user, Errors userErrors, Company company) {
        if (userErrors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        userService.addCompanyUser(user);
        companyService.insertCompany(company);
        return "redirect:/admin/userList";
    }

}
