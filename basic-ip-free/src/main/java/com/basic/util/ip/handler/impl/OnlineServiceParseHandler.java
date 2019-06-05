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
 * @name: OnlineServiceParseHandler
 * @author: Stars Hung
 * @date: 10:32 2019/5/31
 **/
public class OnlineServiceParseHandler extends IPParserHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(OnlineServiceParseHandler.class);

    @Override
    protected IPParseResult parseIp(String ip) throws IOException, ParseIPException {
        JSONObject jsb = doGet(String.format(ONLINE_SERVICE_URL, ip));
        LOGGER.info("[{}]解析ip地址-[{}],解析结果-[{}]", this.getHandlerName(), ip, jsb.toJSONString());
        if (null == jsb || jsb.isEmpty() || !ONLINE_PARSE_RESULT_SUCCESS_CODE.equals(jsb.getInteger(ONLINE_PARSE_STATUS_KEY))) {
            throw new ParseIPException(ONLINE_PARSE_EXCEPTION_CODE, String.format(ONLINE_PARSE_EXCEPTION_MSG, ip));
        }
        String country = jsb.getJSONObject(DATA_KEY).getString(COUNTRY_KEY);
        String province = jsb.getJSONObject(DATA_KEY).getString(PROVINCE_KEY);
        String city = jsb.getJSONObject(DATA_KEY).getString(CITY_KEY);
        return buildResult(country, province, city);
    }

    @Override
    protected String getHandlerName() {
        return this.getClass().getName();
    }
}
