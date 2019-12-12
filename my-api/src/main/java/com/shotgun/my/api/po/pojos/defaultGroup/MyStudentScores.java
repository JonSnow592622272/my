package com.shotgun.my.api.po.pojos.defaultGroup;

import java.io.Serializable;

/**
 * 表名：my_student_scores
 * 分数表
 *
 */
public class MyStudentScores implements Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /** 学生id */
    private Long studentId;
    /** 类型#YUWEN,1,语文;SHUXUE,2,数学;YINGYU,3,英语; */
    private Integer type;
    /** 分数 */
    private Integer scores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyStudentScores withId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public MyStudentScores withStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public MyStudentScores withType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public MyStudentScores withScores(Integer scores) {
        this.scores = scores;
        return this;
    }

}
