package com.cpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherAction {
    @RequestMapping("/other")
    public String other(){
        System.out.println("other__________________");
        return "main";
    }
}
