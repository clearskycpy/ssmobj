package com.cpy.test;

import com.cpy.pojo.School;
import com.cpy.pojo.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    public static ApplicationContext ac;
    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void test01(){
//        Student s = new Student();
//        System.out.println(s);
    }

    @Test
    public void testSpring(){
//        使用spring容器创建对象  IOC
//        1 创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//          2 从容器中拿出对象
        Student student = (Student) ac.getBean("stu");
        System.out.println(student);
    }

    @Test
    public void testSpring2(){
//        给创建的对象赋值
//        使用set注入 或者构造方法注入
        Student student = (Student) ac.getBean("stu");
        System.out.println(student);
    }

    @Test
    public void testSpring3(){
//        给创建的对象赋值
//        使用set注入 或者构造方法注入
        School school = (School) ac.getBean("school");
        System.out.println(school);
    }

}
