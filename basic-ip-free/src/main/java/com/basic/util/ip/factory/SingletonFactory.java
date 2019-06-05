package com.basic.util.ip.factory;

import com.basic.util.ip.handler.IPParserHandler;
import com.basic.util.ip.handler.impl.AliParseHandler;
import com.basic.util.ip.handler.impl.ApiParseHandler;
import com.basic.util.ip.handler.impl.OnlineServiceParseHandler;

import java.util.LinkedList;

/**
 * @description:
 * @name: SingletonFactory
 * @author: Stars Hung
 * @date: 15:08 2019/6/4
 **/
public class SingletonFactory {

    private static SingletonFactory singleton;
    private static LinkedList<IPParserHandler> handlers;

    private SingletonFactory() {
    }

    public static SingletonFactory getInstance() {
        if (null == singleton) {
            synchronized (SingletonFactory.class) {
                if (null == singleton) {
                    singleton = new SingletonFactory();
                    handlers = new LinkedList<>();
                    IPParserHandler aliParseHandler = new AliParseHandler();
                    IPParserHandler apiParseHandler = new ApiParseHandler();
                    IPParserHandler onlineServiceParseHandler = new OnlineServiceParseHandler();
                    aliParseHandler.setNextHandler(onlineServiceParseHandler);
                    onlineServiceParseHandler.setNextHandler(apiParseHandler);
                    handlers.add(aliParseHandler);
                    handlers.add(apiParseHandler);
                    handlers.add(onlineServiceParseHandler);
                    return singleton;
                }
            }
        }
        return singleton;
    }

    public LinkedList<IPParserHandler> getHandlers() {
        return handlers;
    }
}
