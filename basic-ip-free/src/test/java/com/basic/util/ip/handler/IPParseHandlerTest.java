package com.basic.util.ip.handler;

import com.basic.util.ip.model.IPParseResult;
import org.junit.Test;

/**
 * @description:
 * @name: IPParseHandlerTest
 * @author: Stars Hung
 * @date: 11:09 2019/6/4
 **/
public class IPParseHandlerTest {

    @Test
    public void testParseIp(){
        System.out.println(IPParserHandler.getInstance().parseIpAddr("110.185.174.48"));
    }
}
