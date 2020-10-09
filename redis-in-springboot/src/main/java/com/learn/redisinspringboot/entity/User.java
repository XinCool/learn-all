package com.learn.redisinspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cool
 * @create 2020-09-14 16:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private Integer id;
    private Long uid;
    private String password;
}
