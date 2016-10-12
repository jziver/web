package com.example.controller.admin;

import com.example.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminGraduateController {

    private GraduateService graduateService;

    @Autowired
    public AdminGraduateController(GraduateService graduateService) {
        this.graduateService = graduateService;
    }


    @RequestMapping(value = "/graduateList",method = RequestMethod.GET)
    public String graduateList(Model model){
        model.addAttribute("gdList",graduateService.findAll());
        model.addAttribute("page","#" + "graduateList");
        return "admin/home";
    }
}
