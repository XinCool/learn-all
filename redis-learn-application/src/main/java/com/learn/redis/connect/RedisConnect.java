package com.learn.redis.connect;


import com.learn.redis.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cool
 * @create 2020-09-14 11:30
 */
public class RedisConnect {
    public static void main(String[] args) {
        //通过自定义的JedisPoolUtil连接
        Jedis jedis = JedisPoolUtil.getJedis();

        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

//        oprString(jedis);
        oprHash(jedis);
//        oprList(jedis);
//        oprSet(jedis);
//        oprZset(jedis);

        jedis.close();
        System.out.println("服务正在运行: " + jedis.ping());
    }


    /**
     * java连接
     *
     * @return
     */
    public static Jedis connectByJava() {
        Jedis jedis = new Jedis("localhost");
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
        // jedis.auth("1234");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        return jedis;
    }

    /**
     * redis连接池连接
     *
     * @return
     */
    public static Jedis connectByPool() {

        //配置并创建redis连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大闲置个数
        jedisPoolConfig.setMaxIdle(30);
        //最小闲置个数
        jedisPoolConfig.setMinIdle(10);
        //最大连接数
        jedisPoolConfig.setMaxTotal(50);

        JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379);

        Jedis jedis = pool.getResource();

        //各种操作


        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        return jedis;
    }

    public static void oprString(Jedis jedis) {
        System.out.println(jedis.exists("class"));

        //set
        System.out.println(jedis.set("class", "HP161"));

        //setnx
        System.out.println(jedis.setnx("class", "HP171"));
        System.out.println(jedis.setnx("class1", "HP171"));
        //在字符串后添加字符
        System.out.println(jedis.append("class", "班"));

        //get
        System.out.println("value：" + jedis.get("class"));
        System.out.println("value：" + jedis.get("class1"));
        //mget
        List<String> mget = jedis.mget("class", "class1");
        System.out.println(mget);
        //getset
        System.out.println(jedis.getSet("class1", "newHP20"));
        System.out.println(jedis.get("class1"));

        System.out.println(jedis.exists("class"));
        System.out.println("del----------" + jedis.del("class"));
        System.out.println(jedis.exists("class"));
    }

    public static void oprHash(Jedis jedis) {
        System.out.println(jedis.flushDB());
        System.out.println(jedis.del("hashKey"));
        System.out.println(jedis.exists("hashKey"));
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("username", "cxx");
        hashMap.put("password", "1234");
        hashMap.put("phone", "17762007242");

        System.out.println(jedis.hmset("hashKey", hashMap));
        System.out.println(jedis.hlen("hashKey"));
        System.out.println(jedis.hgetAll("hashKey"));
        System.out.println(jedis.hget("hashKey", "username"));

        System.out.println("keys:" + jedis.hkeys("hashKey"));
        System.out.println("values:" + jedis.hvals("hashKey"));

        System.out.println(jedis.exists("hashKey"));
        System.out.println("del----------" + jedis.del("class"));
        System.out.println(jedis.exists("hashKey"));
    }

    public static void oprList(Jedis jedis) {
        //jedis.lpush("listDemo","value00","value11","value22","value33","value44","value55");

        System.out.println(jedis.llen("listDemo"));
        System.out.println(jedis.lrange("listDemo", 0, 1));
    }

    public static void oprSet(Jedis jedis) {

    }

    public static void oprZset(Jedis jedis) {

    }
}
