package com.atguigu.proxy.cglib;

import com.atguigu.proxy.TestInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test implements TestInterface {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayHello1() {
        System.out.println("sayHello1");
    }


    //实现MethodInterceptor接口注册回调函数对代理类中所有方法进行拦截增强
    public static class MyInvocationHandler implements MethodInterceptor {

        //o为继承了被代理类的代理类对象，method为执行方法，objects为方法参数
        //methodProxy为代理对象方法，其中有被代理方法和代理方法的映射关系
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("增强方法");
            //invokeSuper方法传入的对象必须是代理类的实例对象
            //invoke方法则可以穿入被代理类的实例对象，通过被代理类实例调用方法
            return methodProxy.invokeSuper(o,objects);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Test.class);
        enhancer.setCallback(new MyInvocationHandler());
        TestInterface testInterface = (TestInterface)enhancer.create();
        testInterface.sayHello();
    }

}
 
