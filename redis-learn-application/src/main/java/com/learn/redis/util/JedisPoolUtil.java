package com.learn.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Cool
 * @create 2020-09-14 14:05
 */
public class JedisPoolUtil {
    public static JedisPool pool = null;

    static {
        // 加载配置文件
        InputStream in = JedisPoolUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获得池子对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("redis.maxTotal")));
        // 最小闲置个数
        jedisPoolConfig.setMinIdle(Integer.parseInt(properties.getProperty("redis.minIdle")));
        // 最大闲置个数
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("redis.maxIdle")));
        //redis端口
        String url = properties.getProperty("redis.url");
        int post = Integer.parseInt(properties.get("redis.post").toString());
        pool = new JedisPool(jedisPoolConfig, url, post);
    }

    /**
     * 获得Jedis资源
     *
     * @return
     */
    public static Jedis getJedis() {
        return pool.getResource();
    }


}
