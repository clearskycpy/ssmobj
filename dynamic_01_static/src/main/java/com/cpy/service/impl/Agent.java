package com.cpy.service.impl;

import com.cpy.service.Service;

/**
 * 代理对象
 */
public class Agent implements Service {


    //    成员变量
    public Service target;
    /**
     * @param target 构造方法
     */
    public Agent(Service target) {
        this.target = target;
    }

    public void sing() {
        System.out.println("加强方法一");
        System.out.println("加强方法er");
        UserAImpl userA = new UserAImpl(); // 缺少了多变性 固定了实现类
        userA.sing();
        System.out.println("over");
    }
}
