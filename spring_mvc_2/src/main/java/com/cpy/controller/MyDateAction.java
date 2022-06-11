package com.cpy.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MyDateAction {
    @RequestMapping("/mydate")
    public void myDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date mydate){
        System.out.println(mydate);

    }
}
