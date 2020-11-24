package com.redis.demo.controller;

import com.redis.demo.bean.ListBean;
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
@RequestMapping("/list")
public class RedisListController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 不存在增加一个key，多个value;存在则修改
     * @param listBean
     * @return
     */
    @PostMapping("/add-one-list")
    @ResponseBody
    public List<String> addOneList(@RequestBody ListBean listBean) {
        String key = listBean.getKey();
        List<String> values = listBean.getValues();
        redisTemplate.opsForList().leftPushAll(key, values);
        long endIndex = (long) redisTemplate.opsForList().size(key)-1;
        return redisTemplate.opsForList().range(key,0,endIndex);
    }
    
    
    
    /**
     * 根据指定key获取
     * @param key
     * @return
     */
    @GetMapping("/get/{key}")
    @ResponseBody
    public List<String> getListByKey(@PathVariable("key") String key) {
        return redisTemplate.opsForList().range(key,0,(long) redisTemplate.opsForList().size(key)-1);
    }

    /**
     * 根据指定key指定field获取
     * @param key
     * @param index
     * @return
     */
    @GetMapping("/get/{key}/{index}")
    @ResponseBody
    public Object getListbyIndex(@PathVariable("key") String key, @PathVariable("index") String index) {
        long idx ;
        try {
            idx = Long.parseLong(index);
        }catch (Exception e){
            return "index的值为Long类型";
        }
        return "\""+key+"["+index+"]"+"\":\""+redisTemplate.opsForList().index(key,idx)+"\"";
    }


    /**
     * 查找匹配的key值
     * @param key
     * @return
     */
    @GetMapping("/getKey/{key}")
    public Set<String> getPatternKey(@PathVariable("key") String key){
        return redisTemplate.keys(key);
    }


    /**
     * 根据多个key批量删除
     * @param keys
     * @return
     */
    @PostMapping("/dels")
    @ResponseBody
    public String dels(@RequestBody List<String> keys) {
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

    /**
     * 删除集合中值等于value的元素
     * index=0, 删除所有值等于value的元素;
     * index>0, 从头部开始删除第一个值等于value的元素;
     * index<0, 从尾部开始删除第一个值等于value的元素。
     * @param
     * @return
     */
    @GetMapping("/del-by-value/{key}/{index}/{value}")
    @ResponseBody
    public String delBykeyfield(@PathVariable("key") String key, @PathVariable("index") String index,@PathVariable("value") String value){
        Long remove = redisTemplate.opsForList().remove(key, Long.parseLong(index), value);
        return "删除"+remove+"个";
    }



}
