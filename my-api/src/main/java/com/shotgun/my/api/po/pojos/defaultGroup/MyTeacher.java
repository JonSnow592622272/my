package com.shotgun.my.api.po.pojos.defaultGroup;

import java.io.Serializable;

/**
 * 表名：my_teacher
 * 教师表
 *
 */
public class MyTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyTeacher withId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTeacher withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MyTeacher withAge(Integer age) {
        this.age = age;
        return this;
    }

}
