package com.nick.testredis;/*
 * @Author      : Nick
 * @Description :
 * @Date        : Create in 07:18 2018/4/28
 **/

import com.nick.testredis.util.RedisDBUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@org.testng.annotations.Test
public class Test {

    @org.testng.annotations.Test
    public void test(){

        Jedis jedis = new Jedis("127.0.0.1",6379);
        String name = jedis.get("name");
        System.out.println(name);
        jedis.set("name","hello3"+name);
        String name1 = jedis.get("name");
        System.out.println(name1);
    }

    @org.testng.annotations.Test
    public void getTestRedis(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大和最小空闲数
        jedisPoolConfig.setMaxIdle(30);
        jedisPoolConfig.setMinIdle(10);
        //最大连接数
        jedisPoolConfig.setMaxTotal(60);
        //新建一个连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        Jedis resource = jedisPool.getResource();
        String string = resource.get("name");
        System.out.println("name>>"+ string);
        resource.close();
        jedisPool.close();
    }

    @org.testng.annotations.Test
    public void useRedisDBUtils(){
        Jedis jedis = RedisDBUtils.getJedis();
        String string = jedis.get("name");
        System.out.println("name1>>"+ string);
        jedis.close();
    }
}
