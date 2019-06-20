package com.basic.cache.redis.jedis.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * @description:
 * @name: MessageProcessor
 * @author: Stars Hung
 * @date: 11:33 2019/6/17
 **/
public class MessageProcessor extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(Thread.currentThread().getName() + "-接收到消息:channel=" + channel + ",message=" + message);
        //接收到exit消息后退出
        if (Subscriber.EXIT_COMMAND.equals(message)) {
            System.exit(0);
        }
    }
}
