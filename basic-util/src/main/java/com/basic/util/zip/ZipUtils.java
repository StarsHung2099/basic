package com.basic.util.zip;

import com.basic.util.constants.Constants;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @description:
 * @name: ZipUtils.java
 * @author: Stars Hung
 * @date: 10:19 2019/4/15
 **/
public class ZipUtils implements Constants {

    /**
     * 打包文件并以partnerEmail加密，并放到指定目录下
     *
     * @param file      需要压缩的文件/文件夹
     * @param directory 存放目录
     * @param password  加密密码
     * @return 压缩文件
     */
    public static ZipFile packageAndEncryptFile(File file, String directory, String password) throws ZipException {
        String targetFilePath = directory.concat(File.separator).concat(file.getName().replace(SUFFIX_TXT, SUFFIX_ZIP));
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);            // 压缩方式
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);    // 压缩级别
        parameters.setEncryptFiles(true);
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);    // 加密方式
        parameters.setPassword(password.toCharArray());
        ZipFile zipFile = new ZipFile(targetFilePath);
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            ArrayList<File> temp = new ArrayList<>();
            Collections.addAll(temp, subFiles);
            zipFile.addFiles(temp, parameters);
        } else {
            zipFile.addFile(file, parameters);
        }
        return zipFile;
    }
}
