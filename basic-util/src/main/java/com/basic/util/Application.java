package com.basic.util;

import com.basic.util.constants.Constants;
import com.basic.util.encrypt.MD5Utils;
import com.basic.util.io.FileUtils;
import com.basic.util.zip.ZipUtils;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @name: Application.java
 * @author: Stars Hung
 * @date: 10:19 2019/4/15
 **/
public class Application implements Constants {
    static final String SUFFIX_EMAIL = "@camail.com";

    public static void main(String[] args) {
        //解析输入参数
        Assert.assertTrue("请确认已经输入商户统一社会信用代码",args.length >= 2);
        //商户号
        String partnerNo = args[0];
        Assert.assertTrue("商户统一社会信用代码不能为空", StringUtils.isNotBlank(partnerNo));
        String partnerEmail = partnerNo.concat(SUFFIX_EMAIL);
        //当前脚本工作目录
        String directory = args[1];
        Assert.assertTrue("工作目录不能为空", StringUtils.isNotBlank(directory));
        System.out.println(String.format("===接收到用户参数，商户统一社会信用代码: %s, 盐值: %s, 工作目录: %s.===", partnerNo, partnerEmail, directory));
        try {
            //计算MD5摘要
            String md5Digest = MD5Utils.generateMD5String(partnerNo, partnerEmail);
            //生成摘要文件
            File file = FileUtils.generateFileByString(md5Digest, directory, partnerNo.concat(SUFFIX_TXT));
            System.out.println(String.format("===生成摘要文件，文件目录- %s.===", file.getAbsolutePath()));
            //压缩打包
            ZipFile zipFile = ZipUtils.packageAndEncryptFile(file, directory, partnerEmail);
            System.out.println(String.format("===生成加密压缩文件，文件目录-%s.===", zipFile.getFile().getAbsolutePath()));
            file.delete();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(String.format("===MD5摘要计算异常，异常信息-%s.===", e));
        } catch (IOException e) {
            System.out.println(String.format("===摘要文件生成异常，异常信息-%s.===", e));
        } catch (ZipException e) {
            System.out.println(String.format("===zip打包异常，异常信息-%s.===", e));
        }

    }
}
