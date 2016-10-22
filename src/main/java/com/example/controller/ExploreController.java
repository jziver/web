package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 发现
 */
@Controller
public class ExploreController {

    @RequestMapping(value = "explore",method = RequestMethod.GET)
    public String explore(){
        return "explore";
    }

}
