package com.example.controller.admin;

import com.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminCompanyController {


    private CompanyService companyService;

    @Autowired
    public AdminCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/companyManager",method = RequestMethod.GET)
    public String companyManager(Model model){
        model.addAttribute("coms",companyService.findAll());
        model.addAttribute("page","#" + "coms");
        return "admin/home";
    }

}
