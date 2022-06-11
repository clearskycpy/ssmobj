package com.cpy.bean;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("wucanzhixingle");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
