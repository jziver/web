package com.example.controller.admin;

import com.example.model.Graduate;
import com.example.model.Major;
import com.example.model.User;
import com.example.service.GraduateService;
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
public class AdminGraduateController {

    private GraduateService graduateService;
    private UserService userService;
    @Autowired
    public AdminGraduateController(GraduateService graduateService,UserService userService) {
        this.graduateService = graduateService;
        this.userService = userService;
    }

    @RequestMapping(value = "/addGdeUser",method = RequestMethod.POST)
    public String addGdeUser(@Valid User user, Errors errors, Graduate graduate){
        if (errors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        userService.addCompanyUser(user);
        graduateService.insert(graduate);
        return "redirect:/admin/userList";
    }


    @RequestMapping(value = "/graduateList",method = RequestMethod.GET)
    public String graduateList(Model model){
        model.addAttribute("gdList",graduateService.findAll());
        model.addAttribute("page","#" + "graduateList");
        return "admin/home";
    }
}
