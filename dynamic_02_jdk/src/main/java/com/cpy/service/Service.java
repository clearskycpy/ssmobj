package com.cpy.service;

import java.util.Date;

/**
 * 业务层接口  使用jdk动态代理的方式实现代理对象
 */
public interface Service {
    public void sing();
    public String things(Date date);
}
