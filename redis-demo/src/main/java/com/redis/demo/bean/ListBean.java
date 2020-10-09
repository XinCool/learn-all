package com.redis.demo.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Cool
 * @create 2020-09-17 9:54
 */
@Data
public class ListBean {
    private String key;
    private List<String> values;
}
