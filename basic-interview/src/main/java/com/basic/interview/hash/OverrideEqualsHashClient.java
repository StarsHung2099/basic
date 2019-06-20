package com.basic.interview.hash;

import java.util.*;

/**
 * @Description
 * @Author Stars-Hung
 * @Date 21:38 2019/6/19
 * @Version 1.0
 **/
public class OverrideEqualsHashClient {

    public static void main(String[] args) {
//        Set<OverrideEqualsStudent> studentSet = new HashSet<>();
        Map<OverrideEqualsStudent, OverrideEqualsStudent> studentMap = new HashMap<>();
        List<OverrideEqualsStudent> studentList = new ArrayList<>();

        for (int i = 1; i < 100001; i++) {
            OverrideEqualsStudent student = new OverrideEqualsStudent();
            student.setName("stars");
            student.setAge(60);
//            studentSet.add(student);
            if (i % 125 == 0) {
                studentList.add(student);
                studentMap.put(student, student);
            }else{
                studentMap.put(student, student);
            }
        }

        for (OverrideEqualsStudent student : studentList) {
            Long start = System.currentTimeMillis();
            OverrideEqualsStudent stu = studentMap.get(student);
            System.out.println(stu.hashCode() + " = " + (System.currentTimeMillis() - start));
        }
    }
}
