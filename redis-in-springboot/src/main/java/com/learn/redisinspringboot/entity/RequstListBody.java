package com.learn.redisinspringboot.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Cool
 * @create 2020-09-14 17:13
 */
@Data
public class RequstListBody {
    private String key;
    private List<String> values;
}
