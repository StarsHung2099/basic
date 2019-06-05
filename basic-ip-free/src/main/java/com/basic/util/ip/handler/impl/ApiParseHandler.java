package com.basic.util.ip.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.basic.util.ip.exception.ParseIPException;
import com.basic.util.ip.handler.IPParserHandler;
import com.basic.util.ip.model.IPParseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @description:
 * @name: ApiParseHandler
 * @author: Stars Hung
 * @date: 10:34 2019/5/31
 **/
public class ApiParseHandler extends IPParserHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApiParseHandler.class);

    @Override
    protected IPParseResult parseIp(String ip) throws IOException, ParseIPException {
        JSONObject jsb = doGet(String.format(API_URL, ip));
        LOGGER.info("[{}]解析ip地址-[{}],解析结果-[{}]", this.getHandlerName(), ip, jsb.toJSONString());
        if (null == jsb || jsb.isEmpty()) {
            throw new ParseIPException(API_PARSE_EXCEPTION_CODE, String.format(API_PARSE_EXCEPTION_MSG, ip));
        }
        String country = jsb.getString(COUNTRY_KEY);
        String province = jsb.getString(REGION_KEY);
        String city = jsb.getString(CITY_KEY);
        return buildResult(country, province, city);
    }

    @Override
    protected String getHandlerName() {
        return this.getClass().getName();
    }
}
