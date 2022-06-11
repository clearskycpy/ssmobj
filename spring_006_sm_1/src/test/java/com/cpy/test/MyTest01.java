package com.cpy.test;

import com.cpy.pojo.Accounts;
import com.cpy.pojo.User;
import com.cpy.service.AccountsService;
import com.cpy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class MyTest01 {
    @Test
    public void sss(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext_Service.xml");
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        String s = UUID.randomUUID().toString().substring(28);
        int dd =userService.insert(new User(31,s,"123456"));
        System.out.println(s);

    }
    @Test
    public void sss2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext_Service.xml");
        AccountsService accountsService = (AccountsService) ac.getBean("accountsServiceImpl");
        int s =accountsService.save(new Accounts(34,"roohht","10000"));
        System.out.println(s);
    }
}
