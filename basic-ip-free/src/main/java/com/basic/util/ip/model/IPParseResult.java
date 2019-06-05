package com.basic.util.ip.model;

import lombok.Data;

/**
 * @description:
 * @name: IPParseResult
 * @author: Stars Hung
 * @date: 10:03 2019/5/31
 **/
@Data
public class IPParseResult {
    /**
     * 国家
     */
    private String country;

    /**
     * 省份/地区
     */
    private String region;

    /**
     * 城市/州/郡
     */
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
