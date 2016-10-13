package com.example.controller.admin;

import com.example.model.User;
import com.example.service.MajorService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminUserController {
    private UserService userService;
    private MajorService majorService;

    @Autowired
    public AdminUserController(UserService userService, MajorService majorService) {
        this.userService = userService;
        this.majorService = majorService;
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserPage(Model model) {
        model.addAttribute("page", "#" + "addUser");
        model.addAttribute("majors",majorService.findAll());
        return "admin/home";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("page", "#" + "userList");
        return "admin/home";
    }


    @RequestMapping(value = "/addAdminUser",method = RequestMethod.POST)
    public String addAdminUser(@Valid User user, Errors errors,Model model){
        if(errors.hasErrors()){
            return "redirect:/admin/addUser";
        }
        userService.addAdminUser(user);
        return "redirect:/admin/userList";
    }

}
