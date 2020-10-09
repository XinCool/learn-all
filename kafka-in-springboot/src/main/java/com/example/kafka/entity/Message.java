package com.example.kafka.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Cool
 * @create 2020-09-15 14:41
 */
@Getter
@Setter
public class Message<T> implements Serializable {
    private String id;
    private T content;
}