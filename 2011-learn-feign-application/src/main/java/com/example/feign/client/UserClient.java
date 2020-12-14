package com.example.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Cool
 * @create 2020-12-14 15:32
 */
@FeignClient("")
public interface UserClient {

    @GetMapping("/user")
    String getUsers();

}
