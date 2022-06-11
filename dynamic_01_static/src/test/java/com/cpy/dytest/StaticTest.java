package com.cpy.dytest;

import com.cpy.service.Service;
import com.cpy.service.impl.Agent;
import com.cpy.service.impl.UserAImpl;
import org.junit.Test;

public class StaticTest {
    @Test
    public void staticTest(){
        Service sing = new Agent(new UserAImpl());
//        面向接口编程 。 直接使用接口调用代理对象 同时实现方法增强

        sing.sing();
    }

}
