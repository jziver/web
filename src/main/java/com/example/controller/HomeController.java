package com.example.controller;


import com.example.model.Company;
import com.example.model.Graduate;
import com.example.model.User;
import com.example.service.CompanyService;
import com.example.service.GraduateService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private UserService userService;
    private CompanyService companyService;
    private GraduateService graduateService;

    @Autowired
    public HomeController(UserService userService, CompanyService companyService, GraduateService graduateService) {
        this.userService = userService;
        this.companyService = companyService;
        this.graduateService = graduateService;
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.POST)
    private @ResponseBody Object findUser(@RequestParam String username){
        User user = userService.findByUsername(username);
        final Object[] o = {null};
        user.getRoles().forEach(role -> {
            if("ROLE_COM".equals(role.getName())){
                o[0] = companyService.findByUserId(user.getId());
            }else if("ROLE_GDE".equals(role.getName())){
                Graduate graduate = graduateService.findByUserId(user.getId());
                o[0] = graduate;
            }
        });
        return o[0];
    }


}
