package com.example.controller.admin;

import com.example.model.Graduate;
import com.example.model.Major;
import com.example.model.User;
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

@Controller
@RequestMapping(value = "/admin")
public class AdminGraduateController {

    private GraduateService graduateService;
    private MajorService majorService;

    @Autowired
    public AdminGraduateController(GraduateService graduateService,  MajorService majorService) {
        this.graduateService = graduateService;
        this.majorService = majorService;
    }

    @RequestMapping(value = "/addGdeUser", method = RequestMethod.POST)
    public String addGdeUser(@Valid Graduate graduate, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        try{
            graduateService.insert(graduate);
        }catch (Exception e){
            return "redirect:/admin/addUser";
        }
        return "redirect:/admin/userList";
    }


    @RequestMapping(value = "/graduateList", method = RequestMethod.GET)
    public String graduateList(Model model) {
        model.addAttribute("gdList", graduateService.findAll());
        model.addAttribute("page", "#" + "graduateList");
        return "admin/home";
    }

    @RequestMapping(value = "/addGduPage",method = RequestMethod.GET)
    public String addGduPage(Model model){
        model.addAttribute("majors",majorService.findAll());
        return "admin/addGduPage";
    }

    @RequestMapping(value = "/ajaxAddGraduate",method = RequestMethod.POST)
    public @ResponseBody String ajaxAddGraduate(@Valid Graduate graduate,Errors errors){
        if (errors.hasErrors()) {
            return "redirect:/admin/addUser";
        }
        try {
            graduateService.insert(graduate);
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }


    @RequestMapping(value = "delGdu/{id}",method = RequestMethod.POST)
    public @ResponseBody String delGraduate(@PathVariable Integer id){
        try{
            graduateService.delByUserId(id);
        }catch (Exception e){
            e.printStackTrace();
            return "1";
        }
        return "0";
    }


}
