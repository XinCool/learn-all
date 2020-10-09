package com.redis.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cool
 * @create 2020-09-16 15:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrKeyEntity {
    private String key;
    private Object value;
}
