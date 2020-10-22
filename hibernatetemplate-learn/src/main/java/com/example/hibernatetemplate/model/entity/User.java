package com.example.hibernatetemplate.model.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Cool
 * @create 2020-10-22 14:07
 */
@Data
@Table(name = "user")
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String name;
}
