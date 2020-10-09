package com.learn.redis.enumclass;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cool
 * @create 2020-09-14 14:55
 */
public enum UserMsg {
    //test
    student1("001", "HP151", "17762007242"),
    //test
    student2("002", "HP161", "17762007243"),
    //test
    student3("003", "HP162", "17762007244"),
    //test
    student4("004", "HP171", "17762007245"),
    ;
    private String id;
    private String name;
    private String phone;

    UserMsg(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    private void pratice(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(30);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxTotal(50);
        JedisPool pool = new JedisPool(poolConfig, "localhost");
        Jedis jedis = pool.getResource();
        UserMsg[] values = UserMsg.values();
        for (UserMsg value : values) {
            jedis.hset("student", "id", value.id);
            jedis.hset("student", "name", value.name);
            jedis.hset("student", "phone", value.phone);

        }
        jedis.close();
    }

    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(30);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxTotal(50);
        poolConfig.setMaxWaitMillis(3000);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);

        JedisShardInfo jedisShardInfo = new JedisShardInfo("localhost");
        //jedisShardInfo.setPassword("1234");

        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo);

        ShardedJedisPool pool = new ShardedJedisPool(poolConfig, list);
        ShardedJedis jedis = pool.getResource();
        UserMsg[] values = UserMsg.values();
        for (UserMsg value : values) {
            jedis.hset("studentn", "id", value.id);
            jedis.hset("studentn", "name", value.name);
            jedis.hset("studentn", "phone", value.phone);

        }
        jedis.close();
        System.out.println("初始化完毕！");
        System.exit(0);
    }

}
