package com.atguigu.proxy.feign.annotation;

import com.atguigu.proxy.feign.FeignClientsRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FeignClientsRegistrar.class)
    public @interface EnableFeignClients {

    String[] basePackages() default {};

}
