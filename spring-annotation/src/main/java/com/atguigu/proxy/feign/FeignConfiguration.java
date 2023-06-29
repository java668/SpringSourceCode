package com.atguigu.proxy.feign;

import com.atguigu.proxy.feign.annotation.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/29 18:32
 **/
@Configuration
@EnableFeignClients(
        basePackages = {
            "com.atguigu.proxy.api"
        }
)
public class FeignConfiguration {


}