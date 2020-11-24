package com.redis.demo.controller;

import com.redis.demo.bean.SetBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author Cool
 * @create 2020-09-16 11:25
 */
@RestController
@RequestMapping("/set")
public class RedisSetController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 不存在增加一个key，多个value;存在则修改
     *
     * @param setBean
     * @return
     */
    @PostMapping("/add-one-set")
    @ResponseBody
    public String addOneSet(@RequestBody SetBean setBean) {
        String key = setBean.getKey();
        Set<String> values = setBean.getValues();
        values.forEach(value -> {
            redisTemplate.opsForSet().add(key, value);
        });
        return "ok";
    }


    /**
     * 根据指定key获取
     *
     * @param key
     * @return
     */
    @GetMapping("/get/{key}")
    @ResponseBody
    public Set<String> getSetByKey(@PathVariable("key") String key) {
        Set<String> members = redisTemplate.opsForSet().members(key);
        return members;
    }



    /**
     * 查找匹配的key值
     *
     * @param key
     * @return
     */
    @GetMapping("/getKey/{key}")
    public Set<String> getPatternKey(@PathVariable("key") String key) {
        return redisTemplate.keys(key);
    }


    /**
     * 根据多个key批量删除
     *
     * @param keys
     * @return
     */
    @PostMapping("/dels")
    @ResponseBody
    public String dels(@RequestBody List<String> keys) {
        long delete = 0;
        try {
            delete = (long) redisTemplate.delete(keys);
            return "删除成功" + delete + "个";
        } catch (Exception e) {
            return "删除失败";
        }
    }

    /**
     * 根据指定key删除
     *
     * @param key
     * @return
     */
    @GetMapping("/del/{key}")
    public String del(@PathVariable("key") String key) {
        Boolean delete = false;
        String message;
        if (redisTemplate.hasKey(key)) {
            delete = redisTemplate.delete(key);
            message = "key：" + key + " 存在";
        } else {
            message = "key：" + key + " 不存在";
        }

        if (delete) {
            message += ",删除成功";
        } else {
            message += ",删除失败";
        }
        return message;
    }



}
