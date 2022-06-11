package com.cpy.test;

import com.cpy.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void sss(){
        ApplicationContext ac  = new ClassPathXmlApplicationContext("s01/ApplicationContext.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }
}
