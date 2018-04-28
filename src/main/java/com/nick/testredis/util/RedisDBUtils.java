package com.nick.testredis.util;/*
 * @Author      : Nick
 * @Description :
 * @Date        : Create in 07:37 2018/4/28
 **/

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class RedisDBUtils {
    private static JedisPool jedisPool = null;
    //获取数据源信息
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(Integer.parseInt(bundle.getString("redis.maxId")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(bundle.getString("redis.minId")));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(bundle.getString("redis.maxTotal")));


        jedisPool = new JedisPool(jedisPoolConfig,bundle.getString("redis.ip"),
                Integer.parseInt(bundle.getString("redis.port")));
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
//    public static void getClose(Jedis jedis){
//        jedis.close();
//    }
}
