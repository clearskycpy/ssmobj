package com.cpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 创建对象
 */
@Controller
public class ReqAction {
    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public String req(){
        System.out.println("get");
        return "main";
    }
    @RequestMapping(value = "/req",method = RequestMethod.POST)
    public String req1(){
        System.out.println("get");
        return "main";
    }
}
