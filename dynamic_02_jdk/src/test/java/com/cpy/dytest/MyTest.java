package com.cpy.dytest;

import com.cpy.proxy.ProxyFactory;
import com.cpy.service.Service;
import com.cpy.service.impl.UserA;
import com.cpy.service.impl.UserB;
import org.junit.Test;

import java.util.Date;

public class MyTest {
    @Test
    public void testJdk(){
        ProxyFactory factory = new ProxyFactory(new UserB());
        Service agent = (Service) factory.getAgent();
        agent.sing();
    }

    /**
     * 测试不同方法
     */
    @Test
    public void testJdk2(){
        ProxyFactory factory = new ProxyFactory(new UserA());
        Service agent = (Service) factory.getAgent();
        agent.things(new Date());
        System.out.println(agent);
        System.out.println(factory.getAgent());

    }

}
