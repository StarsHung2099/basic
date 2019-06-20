package com.basic.cache.redis.jedis.pubsub;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @name: Subscriber
 * @author: Stars Hung
 * @date: 11:32 2019/6/17
 **/
public class Subscriber extends Thread {

    public static final String CHANNEL_KEY = "channel:pubsub";
    public static final String EXIT_COMMAND = "exit";

    private MessageProcessor messageProcessor = new MessageProcessor();

    public void consumeMessage() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.subscribe(messageProcessor, CHANNEL_KEY);
    }

    @Override
    public void run() {
        while (true) {
            consumeMessage();
        }
    }

    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        Thread t1 = new Thread(subscriber, "thread5");
        Thread t2 = new Thread(subscriber, "thread6");
        t1.start();
        t2.start();
    }
}
