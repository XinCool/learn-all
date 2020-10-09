package com.redis.demo.controller;

import com.redis.demo.entity.StrKeyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Cool
 * @create 2020-09-16 11:25
 */
@RestController
@RequestMapping("/str")
public class RedisStrController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 新增一个key value；存在则修改，不存在则新建
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/addstr/{key}/{value}")
    public String addStr(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }

    /**
     * 新增多个
     * @param map
     * @return
     */
    @PostMapping("/addstr")
    @ResponseBody
    public String addstr(@RequestBody Map<String,String> map){
        redisTemplate.opsForValue().multiSet(map);
        return "ok";
    }

    /**
     * 获取批量key对应的值
     * @param keys ["key1","key2"]
     * @return
     */
    @PostMapping("/get")
    @ResponseBody
    public List<StrKeyEntity> multiGet(@RequestBody Collection<String> keys) {
        //redisTemplate.opsForValue().multiGet(keys);
        List<StrKeyEntity> strKeyEntities = new ArrayList<>();
        keys.forEach(key->{
            strKeyEntities.add(new StrKeyEntity(key,redisTemplate.opsForValue().get(key)));
        });
        return strKeyEntities;
    }

    /**
     * 获取一个指定key对应的值
     * @param key
     * @return
     */
    @GetMapping("/get/{key}")
    public String get(@PathVariable("key") String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 查找匹配的key值
     * @param key
     * @return
     */
    @GetMapping("/get-by-pattern/{key}")
    public Set<String> getPatternKey(@PathVariable("key") String key){
        return redisTemplate.keys(key);
    }

    /**
     * 根据多个key批量删除
     * @param keys ["key1","key2"]
     * @return
     */
    @PostMapping("/del")
    @ResponseBody
    public String dels(@RequestBody Collection<String> keys) {
        long delete =0;
        try {
           delete = (long)redisTemplate.delete(keys);
            return "删除成功"+delete+"个";
        }catch (Exception e){
            return "删除失败";
        }
    }

    /**
     * 根据指定key删除
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
