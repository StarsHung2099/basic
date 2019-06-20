package com.basic.cache.redis.jedis.pubsub;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @name: Publisher
 * @author: Stars Hung
 * @date: 11:01 2019/6/17
 **/
public class Publisher extends Thread {

    public static final String CHANNEL_KEY = "channel:pubsub";
    private volatile int count;

    public void publishMsg(String message) {
        Jedis jedis = JedisPoolUtils.getJedis();
        Long publish = jedis.publish(CHANNEL_KEY, message);//返回订阅者数量
        System.out.println(Thread.currentThread().getName() + " put message,count=" + count + ",subscriberNum=" + publish);
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            publishMsg("message" + i);
        }
    }

    public static void main(String[] args){
        Publisher publisher = new Publisher();
        Thread t1 = new Thread(publisher, "thread1");
        Thread t2 = new Thread(publisher, "thread2");
        Thread t3 = new Thread(publisher, "thread3");
        Thread t4 = new Thread(publisher, "thread4");
        Thread t5 = new Thread(publisher, "thread5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
