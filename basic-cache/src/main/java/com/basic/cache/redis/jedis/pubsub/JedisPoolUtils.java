package com.basic.cache.redis.jedis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @name: JedisPoolUtils
 * @author: Stars Hung
 * @date: 11:05 2019/6/17
 **/
public class JedisPoolUtils {

    private static JedisPool pool = null;

    public static Jedis getJedis() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(5);
        poolConfig.setMaxWaitMillis(10);
        poolConfig.setMinIdle(1);
        poolConfig.setMaxTotal(20);
        pool = new JedisPool(poolConfig, "47.100.255.72", 6379, 5000, "hong1989blue*");
        return pool.getResource();
    }
}
