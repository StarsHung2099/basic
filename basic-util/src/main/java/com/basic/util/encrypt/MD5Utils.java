package com.basic.util.encrypt;

import com.basic.util.constants.Constants;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @name: MD5Utils.java
 * @author: Stars Hung
 * @date: 10:19 2019/4/15
 **/
public class MD5Utils {

    /**
     * 根据商户号和商户邮箱生成32位MD5摘要
     * @param partnerNo
     * @param partnerEmail
     * @return
     */
    public static String generateMD5String(String partnerNo, String partnerEmail) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(Constants.MD5);
        md.update(partnerNo.concat(partnerEmail).getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }
}
