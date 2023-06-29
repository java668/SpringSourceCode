package com.atguigu.proxy.api;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/29 18:47
 **/

import com.atguigu.proxy.feign.annotation.FeignClient;

@FeignClient(
        name = "producer-demo",
        path = "/test",
        url = "localhost:8080"
)
public interface TestFeignClient {

    String test(String test);

}