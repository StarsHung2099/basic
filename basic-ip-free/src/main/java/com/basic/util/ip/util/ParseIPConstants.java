package com.basic.util.ip.util;

/**
 * @description:
 * @name: ParseIPConstants
 * @author: Stars Hung
 * @date: 15:09 2019/6/5
 **/
public interface ParseIPConstants {

    String API_URL = "https://api.ip.sb/geoip/%s";
    String ALI_URL = "http://ip.taobao.com/service/getIpInfo.php?ip=%s";
    String ONLINE_SERVICE_URL = "http://api.online-service.vip/ip3?ip=%s";
    String ACCEPT = "accept";
    String CONTENT = "application/json";

    int HTTP_CONNECT_TIMEOUT = 0;
    int HTTP_POOL_CONNECT_TIMEOUT = 0;
    int HTTP_SOCKET_CONNECT_TIMEOUT = 0;

    String DATA_KEY = "data";
    String COUNTRY_KEY = "country";
    String REGION_KEY = "region";
    String PROVINCE_KEY = "province";
    String CITY_KEY = "city";

    Integer ALI_PARSE_RESULT_ERROR_CODE = 1;
    String ALI_PARSE_RESULT_KEY = "code";
    String ALI_PARSE_EXCEPTION_CODE = "10001";
    String ALI_PARSE_EXCEPTION_MSG = "ali解析ip-[%s]地址异常";

    Integer ONLINE_PARSE_RESULT_SUCCESS_CODE = 200;
    String ONLINE_PARSE_STATUS_KEY = "status";
    String ONLINE_PARSE_EXCEPTION_CODE = "10002";
    String ONLINE_PARSE_EXCEPTION_MSG = "online-service解析ip-[%s]地址异常";


    String API_PARSE_EXCEPTION_CODE = "10003";
    String API_PARSE_EXCEPTION_MSG = "api解析ip-[%s]地址异常";
}
