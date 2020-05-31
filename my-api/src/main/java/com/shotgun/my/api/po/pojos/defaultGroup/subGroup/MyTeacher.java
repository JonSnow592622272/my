package com.shotgun.my.api.po.pojos.defaultGroup.subGroup;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.shotgun.mycommon.base.base.valid.Goups;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 表名：my_teacher
 * 教师表
 * 验证器分组：groups必须要填写，通用的可以以数组形式设置
 */
public class MyTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Long id;
    /** 姓名 */
    @NotEmpty(message = "姓名不能为空")
    @Length(max = 4, message = "姓名长度不能大于{max}", groups = {Goups.Insert.class})
    private String name;
    /** 年龄 */
    @Range(min = 10, max = 50, message = "年龄不符合", groups = {Goups.UpdateById.class, Goups.UpdateById.class})
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
