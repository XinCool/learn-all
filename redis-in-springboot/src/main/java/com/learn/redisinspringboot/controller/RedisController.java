package com.learn.redisinspringboot.controller;

import com.learn.redisinspringboot.RedisInSpringbootApplication;
import com.learn.redisinspringboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cool
 * @create 2020-09-14 16:07
 */
@RestController("")
public class RedisController {
    public static final Logger logger =  LoggerFactory.getLogger(RedisInSpringbootApplication.class);

    //有参数
    @Cacheable(value="thisredis", key="'users_'+#id")
    public User findUser(Integer id) {
        User user = new User();
        user.setUserName("hlhdidi");
        user.setPassword("123");
        user.setUid(id.longValue());
        System.out.println("log4j2坏啦?");
        logger.info("输入user,用户名:{},密码:{}",user.getUserName(),user.getPassword());
        return user;
    }

    @CacheEvict(value="thisredis",   key="'users_'+#id",condition="#id!=1")
    public void delUser(Integer id) {
        // 删除user
        System.out.println("user删除");
    }

    //无参数
    /*@RequestMapping("/get")
    @Cacheable(value="thisredis")
    @ResponseBody
    public List<User> xx(){
        return userMapper.selectAll();
    }*/
    @RequestMapping("/get3")
    @CacheEvict(value="thisredis")
    @ResponseBody
    public String xx3(){
        return "ok";
    }
}
