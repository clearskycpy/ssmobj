package com.cpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestAction {
    @RequestMapping("/one")
    public String one(){
        return "main";  // m默认使用视图解析器进行页面跳转  默认是请求转发
    }
    @RequestMapping("/two")
    public String two(){
        return "forward:/other.action";  // 转发到action  默认是请求转发 可以屏蔽前缀后缀的拼接forward:
    }
    @RequestMapping("/three")
    public String three(){
        System.out.println("这是重定向");
        return "redirect:/admin/main.jsp";  // m默认使用视图解析器进行页面跳转  默认是请求转发
    }
    @RequestMapping("/four")
    public String four(){
        return "redirect:/other.action";  // m默认使用视图解析器进行页面跳转  默认是请求转发
    }
}
