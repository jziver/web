package com.example.controller.admin;

import com.example.model.User;
import com.example.service.CompanyService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private UserService userService;
    private CompanyService companyService;

    @Autowired
    public AdminController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("page","#" + "home");
        return "admin/home";
    }



    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUserPage(Model model){
        model.addAttribute("page","#" + "addUser");
        return "admin/home";
    }

    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public String userList(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        model.addAttribute("page","#"+"userList");
        return "admin/home";
    }


    @RequestMapping(value = "/companyManager",method = RequestMethod.GET)
    public String companyManager(Model model){
        model.addAttribute("coms",companyService.findAll());
        model.addAttribute("page","#" + "coms");
        return "admin/home";
    }


}
