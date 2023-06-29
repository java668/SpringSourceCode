package com.atguigu.test;

import com.atguigu.proxy.api.TestFeignClient;
import com.atguigu.proxy.feign.FeignConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FeignTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FeignConfiguration.class);
        TestFeignClient bean = applicationContext.getBean(TestFeignClient.class);
        bean.test("aaaaaaaaaa");
        applicationContext.close();
    }

}
