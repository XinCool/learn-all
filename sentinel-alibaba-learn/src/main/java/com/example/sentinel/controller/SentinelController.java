package com.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cool
 * @create 2020-10-28 17:41
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping(value = "/hello")
    @SentinelResource(value = "hello")
    public String hello() {
        return "Hello,Sentinel";
    }
}
