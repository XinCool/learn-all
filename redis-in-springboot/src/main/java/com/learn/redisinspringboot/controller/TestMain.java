package com.learn.redisinspringboot.controller;

import com.learn.redisinspringboot.entity.RequstListBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Cool
 * @create 2020-09-14 16:39
 */
@RestController
@RequestMapping("/redis")
public class TestMain {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getStr/{key}")
    @ResponseBody
    public String getStr(@PathVariable("key") String key){
        ValueOperations value = redisTemplate.opsForValue();
        return value.get(key).toString();
    }

    @GetMapping("/addStr/{key}/{value}")
    @ResponseBody
    public String addStr(@PathVariable("key") String key,@PathVariable("value") String value){
        ValueOperations<String,String> value1 = redisTemplate.opsForValue();
        value1.set(key,value);
        return key+":"+value1.get(key).toString();
    }

    @GetMapping("/delStr/{key}")
    @ResponseBody
    public String delStr(@PathVariable("key") String key){
        ValueOperations<String,String> value = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
            return "删除成功";
        }
        return "数据库不存在该key";
    }

    @PostMapping("/addList")
    @ResponseBody
    public String addList(@RequestBody RequstListBody requstListBody){
        String key = requstListBody.getKey();
        ListOperations<String,String> operations = redisTemplate.opsForList();
        Long aLong = operations.leftPushAll(key, requstListBody.getValues());
        System.out.println(aLong);
        List<String> range = operations.range(key, 0, -1);
        System.out.println(range);
        return range.toString();
    }

}
