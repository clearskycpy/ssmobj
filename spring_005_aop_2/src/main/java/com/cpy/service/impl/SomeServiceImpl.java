package com.cpy.service.impl;

import com.cpy.service.SomeService;
//业务实现类
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome(String name, int age) {
        System.out.println("dosome>>>>>>>>>>");
        return "abcd";
    }
}
