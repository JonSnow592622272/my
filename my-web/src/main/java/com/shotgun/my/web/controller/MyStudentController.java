package com.shotgun.my.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyStudentServiceApi;
import com.shotgun.my.api.api.defaultGroup.subGroup.TestBbbServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyStudent;
import com.shotgun.mycommon.base.base.api.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wulm
 **/
@RestController
//@RequestMapping("mystudent")
public class MyStudentController {

    @Autowired
    private TestBbbServiceApi testBbbService;

    @Autowired
    private MyStudentServiceApi myStudentServiceApi;

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insert")
    public ResultInfo insert(MyStudent myStudent) {
        return myStudentServiceApi.insert(myStudent);
    }

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insertBatch")
    public ResultInfo insertBatch(MyStudent myStudent) {
        return myStudentServiceApi.insertBatch(myStudent);
    }

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insertBatch2")
    public ResultInfo insertBatch(@RequestBody List<MyStudent> myStudents) {
        return myStudentServiceApi.insertBatch(myStudents);
    }

    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());

        IPage<MyStudent> myStudentIPage = myStudentServiceApi.testGet102("aaa", "bbbbbbbbbbbbbbbbbbbb");
        return "Greetings from Spring Boot! 祝你好运！";
    }



    @PostMapping("/insertTeacher")
    public ResultInfo insertTeacher(MyStudent myStudent) {
        return myStudentServiceApi.insert2(myStudent);
    }



    public static List<MyStudent> getTeachers() {
        List<MyStudent> list = IntStream.range(1, 6).mapToObj(operand -> {
            MyStudent t = new MyStudent();
            t.setName("张三让我恩服务费");
            t.setAge(operand);
            return t;
        }).collect(Collectors.toList());
        return list;
    }

}