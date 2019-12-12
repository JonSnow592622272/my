package com.shotgun.my.api.po.pojos.defaultGroup;

import java.io.Serializable;

/**
 * 表名：my_student
 * 学生表
 *
 */
public class MyStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
    /** 教师id */
    private Long teacherId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyStudent withId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyStudent withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MyStudent withAge(Integer age) {
        this.age = age;
        return this;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public MyStudent withTeacherId(Long teacherId) {
        this.teacherId = teacherId;
        return this;
    }

}
