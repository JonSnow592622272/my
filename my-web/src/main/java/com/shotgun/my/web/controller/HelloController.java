package com.shotgun.my.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.api.defaultGroup.subGroup.TestBbbServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private TestBbbServiceApi testBbbService;

    @Autowired
    private MyTeacherServiceApi myTeacherServiceApi;


    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());


        IPage<MyTeacher> myTeacherIPage = myTeacherServiceApi.testGet10();
        return "Greetings from Spring Boot! 祝你好运！";
    }

    @RequestMapping("/testGet10")
    public IPage<MyTeacher> testGet10() {

        IPage<MyTeacher> myTeacherIPage = myTeacherServiceApi.testGet10();
        return myTeacherIPage;
    }

}