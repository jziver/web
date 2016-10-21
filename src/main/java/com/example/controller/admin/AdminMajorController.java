package com.example.controller.admin;

import com.example.model.Major;
import com.example.model.Position;
import com.example.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminMajorController {

    private MajorService majorService;

    @Autowired
    public AdminMajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @RequestMapping(value = "/majorManager", method = RequestMethod.GET)
    public String majorManager(Model model) {
        model.addAttribute("majorList", majorService.findAll());
        model.addAttribute("page", "#" + "majorList");
        return "admin/home";
    }

    @RequestMapping(value = "addMajorPage", method = RequestMethod.GET)
    public String addMajorForm() {
        return "admin/addMajorPage";
    }

    @RequestMapping(value = "addMajor", method = RequestMethod.POST)
    public @ResponseBody String addMajor(@Valid Major major,String strPositions, Errors errors) {
        if(errors.hasErrors()){
            return "1";
        }
        try {
            List<String> pname = Arrays.asList(strPositions.split(","));
            List<Position> positions = new ArrayList<>();
            for(int i=0;i<pname.size();i++){
                positions.add(new Position(pname.get(i)));
            }
            major.setPositions(positions);

            majorService.insert(major);
        }catch (Exception e){
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

    @RequestMapping(value = "delMj/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    String delMajor(@PathVariable Integer id) {
        try {
            majorService.deleteOne(id);
        } catch (Exception e) {
            return "1";
        }
        return "0";
    }

}
