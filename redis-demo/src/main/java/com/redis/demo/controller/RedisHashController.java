package com.redis.demo.controller;

import com.redis.demo.bean.HashBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Cool
 * @create 2020-09-16 11:25
 */
@RestController
@RequestMapping("/hash")
public class RedisHashController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 不存在增加一个key，多个field及value;存在则修改
     * @param hashBean
     * @return
     */
    @PostMapping("/add-one-hash")
    @ResponseBody
    public Map<Object, Object> addOneHash(@RequestBody HashBean hashBean) {
        String key = hashBean.getKey();
        Map<String, Object> hashMap = hashBean.getHashMap();
        redisTemplate.opsForHash().putAll(key, hashMap);
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    /**
     * 根据指定key获取
     * @param key
     * @return
     */
    @GetMapping("/gethash/{key}")
    @ResponseBody
    public Map<Object, Object> getHashByKey(@PathVariable("key") String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 根据指定key指定field获取
     * @param key
     * @param field
     * @return
     */
    @GetMapping("/gethash/{key}/{field}")
    @ResponseBody
    public Object getHashbyKeyField(@PathVariable("key") String key, @PathVariable("field") String field) {
        return redisTemplate.opsForHash().get(key,field);
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
     * 删除hash表一个或多个字段
     * @param
     * @return
     */
    @PostMapping("/del-by-field")
    @ResponseBody
    public String delBykeyfield(@RequestBody HashBean hashBean){
        List<Object> fields = hashBean.getFields();
        String key = hashBean.getKey();
        if (key!=null && key!=""){
            long delete = 0;
            String result = "";
            for (Object field : fields) {
                if (redisTemplate.opsForHash().hasKey(key,field)){
                    delete += redisTemplate.opsForHash().delete(key, field);
                    result += "删除"+key+"中的表字段"+field+"成功\n";
                }
            }
            return result+"共成功删除"+delete+"个表字段";
        }
        return "key参数不能为空";
    }



}
