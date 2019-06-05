package com.basic.util.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @name: FileUtils
 * @author: Stars Hung
 * @date: 11:47 2019/4/15
 **/
public class FileUtils {
    /**
     * 根据字符串内容在指定目录下生成制定名称的文件
     *
     * @param content
     * @param directory
     * @param fileName
     * @return
     */
    public static File generateFileByString(String content, String directory, String fileName) throws IOException {
        FileWriter writer = new FileWriter(directory + File.separator + fileName, false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(content);
        bufferedWriter.flush();
        bufferedWriter.close();
        writer.close();
        return new File(directory + File.separator + fileName);
    }
}
