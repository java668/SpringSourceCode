package com.atguigu.proxy.feign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//需要定义一个实现了InvocationHandler接口的对象，目的是获取被代理类的实例和自定义增强方法
public class FeignInvocationHandler implements InvocationHandler {
    //被代理类的实例对象
    protected Object target;

    public FeignInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===========" + method.getName());
        //调用被代理类的实例对象通过反射执行目标方法
//        Object result = method.invoke(target, args);
        return "success";
    }
}