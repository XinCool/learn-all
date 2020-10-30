package com.learn.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首先还要配置apollo，sentiel控制台设置规则
 * @author Cool
 * @create 2020-10-29 8:48
 */
@RestController
@RequestMapping("/sentinel")
@Api(value = "测试sentinel熔断")
public class TestController {

    @ApiOperation(value="出现异常的时候会执行blockHandler里面的方法", notes="")
    @PostMapping(value="/test")
    @com.alibaba.csp.sentinel.annotation.SentinelResource(blockHandler="blockHandler")
    public String findApiDetailByPage(){
        System.err.println("test");
        int age = 10/0;
        return "hello";
    }


    //熔断
    @ApiOperation(value = "出现异常执行exceptionHandler方法")
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
