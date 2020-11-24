package com.redis.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Cool
 * @create 2020-09-17 9:09
 */
@Data
public class HashKeyEntity {
    private String key;
    private List<StrKeyEntity> data;
}
