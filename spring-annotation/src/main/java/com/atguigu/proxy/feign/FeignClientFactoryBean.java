package com.atguigu.proxy.feign;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/29 18:33
 **/
public class FeignClientFactoryBean implements FactoryBean<Object> {

    private String url;

    private String name;

    private String path;

    private Class<?> type;


    @Override
    public Object getObject() throws Exception {
        Target.HardCodedTarget target = new Target.HardCodedTarget(type, url, name);
        Object o = Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] {type}, new FeignInvocationHandler(target));
        return o;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}