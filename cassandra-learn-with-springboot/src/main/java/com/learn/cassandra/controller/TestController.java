package com.learn.cassandra.controller;

import com.learn.cassandra.entity.UserEntity;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试cassandra数据
 * @author Cool
 * @create 2020-10-15 11:43
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private CassandraTemplate cassandraTemplate;

    @GetMapping("/get")
    @ResponseBody
    public List<UserEntity> findTopTen() {
        String cql=String.format("select * from user limit 10");
        List<UserEntity> userEntityList = cassandraTemplate.select(cql, UserEntity.class);
        return userEntityList;
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(@RequestBody UserEntity userEntity) {
        //插入
        cassandraTemplate.insert(userEntity);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody UserEntity userEntity) {
        //删除
        cassandraTemplate.delete(userEntity);
    }
}
