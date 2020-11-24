package com.redis.demo.bean;

import lombok.Data;

import java.util.Set;

/**
 * @author Cool
 * @create 2020-09-17 10:29
 */
@Data
public class SetBean {
    private String key;
    private Set<String> values;
}
