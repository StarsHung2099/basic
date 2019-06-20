package com.basic.interview.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Stars-Hung
 * @Date 22:12 2019/6/19
 * @Version 1.0
 **/
public class OriginalHashClient {

    public static void main(String[] args) {
        Map<OriginalStudent, OriginalStudent> originalStudentMap = new HashMap<>();

        for (int i = 0; i < 50; i++) {
            OriginalStudent student = new OriginalStudent();
            student.setName("stars");
            student.setAge(30);
            originalStudentMap.put(student, student);
        }
    }
}
