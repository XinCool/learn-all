package com.example.hibernatetemplate.model.inter;

import com.example.hibernatetemplate.model.entity.User;

/**
 * @author Cool
 * @create 2020-10-22 14:06
 */
 public interface IUser {
    User getById(String id);
    void save(User user);
}
