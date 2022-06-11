package com.cpy.test;

import com.cpy.service.SomeService;
import com.cpy.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void sss(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");  // 使用的是接口去接收代理对象可以 。
        // 如果是实现类就不可以  但是如果采用的是子类代理就可以
        System.out.println(someService.getClass());// class jdk.proxy2.$Proxy9
        String s = someService.doSome("abc",22);
        System.out.println(s);
    }
    @Test
    public void sss2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SomeServiceImpl someService = (SomeServiceImpl) ac.getBean("someService");  // 使用的是接口去接收代理对象可以 。
        // 如果是实现类就不可以  但是如果采用的是子类代理就可以 proxy-target-class="true"
        System.out.println(someService.getClass());// class jdk.proxy2.$Proxy9
        String s = someService.doSome("abc",22);
        System.out.println(s);
    }
}
