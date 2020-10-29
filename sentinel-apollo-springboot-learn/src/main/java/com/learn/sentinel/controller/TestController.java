package com.learn.sentinel.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cool
 * @create 2020-10-29 8:48
 */
@RestController
@RequestMapping("/test")
public class TestController {

    //熔断
    @GetMapping("/fusing")
    @SentinelResource(value="fusing",blockHandler = "exceptionHandler",fallback = "exceptionHandler")
    public String fusing(){
        System.err.println("fusing");
        int age = 10/0;
        return "成功";
    }


    public String exceptionHandler(BlockException e){
        System.err.println("降级方法");
        return "降级方法";
    }
}
