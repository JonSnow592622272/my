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

    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());

        IPage<MyStudent> myStudentIPage = myStudentServiceApi.testGet102("aaa", "bbbbbbbbbbbbbbbbbbbb");
        return "Greetings from Spring Boot! 祝你好运！";
    }

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
    @PostMapping("insertBatchArr")
    public ResultInfo insertBatchArr(MyStudent myStudent) {
        return myStudentServiceApi.insertBatch(myStudent);
    }

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insertBatchCol")
    public ResultInfo insertBatchCol(@RequestBody List<MyStudent> myStudents) {
        return myStudentServiceApi.insertBatch(myStudents);
    }


}