package com.cpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoAction {
    /**
     * action 所有功能都是使用方法实现
     * 访问权限是public
     * 方法返回值是任意
     * 方法名称任意
     * 参数可以没有如果有可以任意类型
     * 要使用@RequestMapping 注解申明
     *
     */
    @RequestMapping("/demo")
    public String demo(){
        System.out.println("服务器被访问到了");
        return "main";
    }


}
