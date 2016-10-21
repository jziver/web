package com.example.controller.admin;

import com.example.model.User;
import com.example.service.CompanyService;
import com.example.service.GraduateService;
import com.example.service.MajorService;
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
public class AdminUserController {
    private UserService userService;
    private MajorService majorService;
    private GraduateService graduateService;
    private CompanyService companyService;

    @Autowired
    public AdminUserController(UserService userService, MajorService majorService, GraduateService graduateService, CompanyService companyService) {
        this.userService = userService;
        this.majorService = majorService;
        this.graduateService = graduateService;
        this.companyService = companyService;
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserPage(Model model) {
        model.addAttribute("page", "#" + "addUser");
        model.addAttribute("majors", majorService.findAll());
        return "admin/home";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("page", "#" + "userList");
        return "admin/home";
    }


    @RequestMapping(value = "/addAdminUser", method = RequestMethod.POST)
    public String addAdminUser(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        userService.addAdminUser(user);
        return "redirect:/admin/userList";
    }


    @RequestMapping(value = "/delUserById/{roleName}/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String delUser(@PathVariable String roleName, @PathVariable Integer id) {
        if (roleName.isEmpty() || id == null) {
            return "1";
        }

        try {
            if ("ROLE_COM".equals(roleName)) {
                companyService.delByUserId(id);
            } else if ("ROLE_GDE".equals(roleName)) {
                graduateService.delByUserId(id);
            } else if("ROLE_ADMIN".equals(roleName)){
                userService.delAdminUser(id);
            }else {
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }

        return "0";
    }

}
