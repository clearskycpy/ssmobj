package com.cpy.proxy;

import com.cpy.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂 使用jdk动态代理生产代理对象
 */
public class ProxyFactory {
//    成员变量  目标对象
    Service target;

    /**
     * 构造方法
     * @param target
     */
    public ProxyFactory(Service target) {
        this.target = target;
    }

    /**
     * 获取动态代理对象 所以不需要代理对象的类
     * @return
     */

    public Object getAgent(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),   // 获取类加载器
                target.getClass().getInterfaces(),  // 获取类所有的接口
                new InvocationHandler() {     // 内部类的形式实现动态代理
                    public Object invoke(Object proxy,  // 创建的代理对象
                                         Method method,  //  目标方法
                                         Object[] args // 目标方法的参数
                    ) throws Throwable {
                        System.out.println("业务一》》》》");
                        System.out.println("业务二？？？？");
//                        代理功能
                        Object obj = method.invoke(target, args);// 采用了调用方法对象的invoke  然后根据 args参数创建对象
                        return obj;
                    }
                });

    }

}
