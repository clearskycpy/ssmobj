package com.cpy.service.impl;

import com.cpy.service.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserA implements Service {

    public void sing() {
        System.out.println("UserA>>>>>>>>");
    }

    public String things(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : hh-mm-ss");
        System.out.println(simpleDateFormat.format(date));
        return "UserA";
    }

}
