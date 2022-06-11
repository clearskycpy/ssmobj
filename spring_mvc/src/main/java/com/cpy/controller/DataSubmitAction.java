package com.cpy.controller;

import com.cpy.bean.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataSubmitAction {
    @RequestMapping("/one")
    public String one(String myname,int age){
        System.out.println(myname + "+  "+"+  "+age);   // 有进行强制类型转换0227
        return "main";
    }
    @RequestMapping("/two")
    public String two(Users user){
        return "main";
    }
    @RequestMapping("/three/{name}/{age}")
    public String three(
            @PathVariable
            String name ,
            @PathVariable
            int age){
        System.out.println(name +age );
        return "main";
    }
    @RequestMapping("/four")
    public String four(
            @RequestParam("name")
                    String uname ,
            @RequestParam("age")
                    int uage){
        System.out.println(uname +uage );
        return "main";
    }

}
