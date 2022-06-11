package com.cpy.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Locale;

@Aspect  // 交给aspect的框架实现切面类
public class MyAspect {
/*    所有的切面功能都是由切面方法实现的可以将各种切面都在此类中进行开发，
    前置通知的方法规范
    使用@before*/
//    这个注解可以让下面这个方法切入到dosome上面
    @Before(value = "execution(public String com.cpy.service.impl.SomeServiceImpl.doSome(String,int))")
    public void myBefore(JoinPoint jo){
        System.out.println("前置通知执行了>>>");
        System.out.println("目标方法的签名"+jo.getSignature());
    }

    /**
     * 后置通知的方法规范
     *    返回权限是public
     *    方法没有返回值 void
     *    方法名自定义
     *    方法有参数 也可以没有参数
     * @AfterReturning
     * value 切入表达式
     * returning 指定目标方法的返回值名称 必须与切面方法的参数名称一致
     */
    @AfterReturning(value = "execution(public String com.cpy.service.impl.SomeServiceImpl.doSome(String,int))"
            ,returning = "obj")
    public void myAfterReturning(Object obj){
        System.out.println("后置通知实现");
        if (obj != null)
            if (obj instanceof String){
                obj = obj.toString().toUpperCase(Locale.ROOT);
                System.out.println("在切面方法"+obj);
            }

    }
    @Around(value = "execution(public String com.cpy.service.impl.SomeServiceImpl.doSome(String,int))")
    public Object MyAround(ProceedingJoinPoint pjo) throws Throwable {
//        前切功能实现
        System.out.println("前切功能实现");
//        目标方法实现  ProceedingJoinPoint 目标方法
        Object obj = pjo.proceed(pjo.getArgs());
//        后切功能实现
        System.out.println("后切功能实现");
        return obj.toString().toUpperCase(Locale.ROOT);
    }
    @After(value = "execution(public String com.cpy.service.impl.SomeServiceImpl.doSome(String,int))")
    public void MyAfter(){
        System.out.println("最终通知");
    }



}
