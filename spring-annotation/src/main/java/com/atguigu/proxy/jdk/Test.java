package com.atguigu.proxy.jdk;


import com.atguigu.proxy.TestInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test implements TestInterface {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayHello1() {
        System.out.println("sayHello1");
    }

    //需要定义一个实现了InvocationHandler接口的对象，目的是获取被代理类的实例和自定义增强方法
    public static class MyInvocationHandler implements InvocationHandler {
        //被代理类的实例对象
        protected Object target;
        public MyInvocationHandler(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("增强方法");
            //调用被代理类的实例对象通过反射执行目标方法
            Object result = method.invoke(target, args);
            return result;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        TestInterface testInterface = (TestInterface) Proxy.newProxyInstance(test.getClass().getClassLoader(), Test.class.getInterfaces(), new MyInvocationHandler(test));
//        testInterface.sayHello();
        testInterface.sayHello1();
    }
}



 
