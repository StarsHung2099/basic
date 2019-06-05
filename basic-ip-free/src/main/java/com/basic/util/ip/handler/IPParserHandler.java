package com.basic.util.ip.handler;

import com.alibaba.fastjson.JSONObject;
import com.basic.util.ip.exception.ParseIPException;
import com.basic.util.ip.factory.SingletonFactory;
import com.basic.util.ip.model.IPParseResult;
import com.basic.util.ip.util.ParseIPConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @description: IPv4解析器
 * @name: IPParserHandler
 * @author: Stars Hung
 * @date: 10:03 2019/5/31
 **/
public abstract class IPParserHandler implements ParseIPConstants {
    public static final Logger LOGGER = LoggerFactory.getLogger(IPParserHandler.class);

    private IPParserHandler nextHandler;

    public static IPParserHandler getInstance() {
        return SingletonFactory.getInstance().getHandlers().get(0);
    }

    /**
     * 解析IPv4地址
     *
     * @param ip
     * @return IPv4解析结果
     */
    public IPParseResult parseIpAddr(String ip) {
        try {
            return parseIp(ip);
        } catch (Exception ex) {
            LOGGER.error("解析ip地址-[{}], 异常信息-{}", ip, ex);
            if (null != this.nextHandler) {
                return nextHandler.parseIpAddr(ip);
            }
            //TODO 到了最后都解析失败，就抛个异常出去
        }
        return null;
    }

    protected JSONObject doGet(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        final RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(HTTP_CONNECT_TIMEOUT).setConnectionRequestTimeout(HTTP_POOL_CONNECT_TIMEOUT)
                .setSocketTimeout(HTTP_SOCKET_CONNECT_TIMEOUT).build();
        request.setHeader(ACCEPT, CONTENT);
        request.setConfig(requestConfig);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(entity.getContent(), JSONObject.class);
    }

    /**
     * 解析ip地址
     *
     * @param ip
     * @return
     */
    protected abstract IPParseResult parseIp(String ip) throws IOException, ParseIPException;

    protected IPParseResult buildResult(String country, String region, String city) {
        IPParseResult result = new IPParseResult();
        result.setCountry(country);
        result.setRegion(region);
        result.setCity(city);
        return result;
    }

    /**
     * 获取拦截器名称
     *
     * @return
     */
    protected abstract String getHandlerName();

    public void setNextHandler(IPParserHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
