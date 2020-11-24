package com.example.akka.iiot.controller;

import com.example.akka.iiot.actors.service.DefaultActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cool
 * @create 2020-10-27 17:40
 */
@RestController
public class ActorController {
    @Autowired
    DefaultActorService defaultActorService;



    @GetMapping("/test")
    public void test(String msg){


    }
}
