package com.basic.interview.hash;

/**
 * @Description
 * @Author Stars-Hung
 * @Date 21:35 2019/6/19
 * @Version 1.0
 **/
public class OverrideEqualsStudent {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (null != obj && obj instanceof OverrideEqualsStudent) {
            OverrideEqualsStudent stu = (OverrideEqualsStudent) obj;
            return this.name.equals(stu.getName()) && this.age.equals(stu.getAge());
        }
        return false;
    }
}
