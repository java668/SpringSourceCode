package com.atguigu.proxy.feign;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/29 18:33
 **/
public class FeignClientFactoryBean<T> implements FactoryBean<T> {

    private String url;

    private String name;

    private Class<T> type;

    public FeignClientFactoryBean(String url, String name, Class<T> type) {
        this.url = url;
        this.name = name;
        this.type = type;
    }

    @Override
    public T getObject() throws Exception {
        Target.HardCodedTarget target = new Target.HardCodedTarget(type, url, name);
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), Target.HardCodedTarget.class.getInterfaces(), new FeignInvocationHandler(target));
        return (T) o;
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }


}