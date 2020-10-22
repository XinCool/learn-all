package com.example.hibernatetemplate.application.controller;

import com.example.hibernatetemplate.model.entity.User;
import com.example.hibernatetemplate.model.inter.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Cool
 * @create 2020-10-22 14:34
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUser userServer;

    @GetMapping("/get-id")
    @ResponseBody
    public User findById(String id){
        return userServer.getById(id);
    }

    @GetMapping("/save{id}/{name}")
    @ResponseBody
    public User save(@PathVariable("id") String id,@PathVariable("name") String name){
        userServer.save(new User(id,name));
        return userServer.getById(id);
    }

}
