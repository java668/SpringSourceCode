package com.atguigu.proxy.feign;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/29 18:32
 **/
@Configuration
@Import(FeignClientsRegistrar.class)
public class FeignConfiguration {


}