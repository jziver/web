package com.example.controller.admin;

import com.example.model.Company;
import com.example.model.User;
import com.example.service.CompanyService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminCompanyController {


    private CompanyService companyService;

    @Autowired
    public AdminCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @RequestMapping(value = "/companyManager", method = RequestMethod.GET)
    public String companyManager(Model model) {
        List<Company> companyList = companyService.findAll();
        model.addAttribute("coms", companyList);
        model.addAttribute("page", "#" + "coms");
        return "admin/home";
    }


    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    public String addCompany(@Valid Company company, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        companyService.insertCompany(company);
        return "redirect:/admin/userList";
    }

    @RequestMapping(value = "/ajaxAddCompany", method = RequestMethod.POST)
    public @ResponseBody String addCompanyAjax(@Valid Company company, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        try {
            companyService.insertCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

    @RequestMapping(value = "/addComPage", method = RequestMethod.GET)
    public String addComFrom() {
        return "admin/addComPage";
    }

    @RequestMapping(value = "/delComByUserId/{id}")
    public @ResponseBody String delComByUserId(@PathVariable Integer id){
        try{
            companyService.delByUserId(id);
        }catch (Exception e){
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

}
