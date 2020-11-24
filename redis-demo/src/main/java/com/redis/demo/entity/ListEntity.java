package com.redis.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Cool
 * @create 2020-09-17 9:52
 */
@Data
public class ListEntity {
    private String key;
    private List<Object> values;
}
