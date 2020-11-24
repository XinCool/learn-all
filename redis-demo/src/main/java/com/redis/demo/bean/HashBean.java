package com.redis.demo.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Cool
 * @create 2020-09-16 15:45
 */
@Data
public class HashBean {
    //key
    private String key;
    //多个键值对
    private Map<String,Object> hashMap;
    private List<Object> fields;
}
