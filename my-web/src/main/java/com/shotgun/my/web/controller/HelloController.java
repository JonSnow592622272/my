package com.shotgun.my.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.api.defaultGroup.subGroup.TestBbbServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.mycommon.base.base.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wulm
 **/
@RestController
public class HelloController {

    @Autowired
    private TestBbbServiceApi testBbbService;

    @Autowired
    private MyTeacherServiceApi myTeacherServiceApi;


    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());


        IPage<MyTeacher> myTeacherIPage = myTeacherServiceApi.testGet102("aaa","bbbbbbbbbbbbbbbbbbbb");
        return "Greetings from Spring Boot! 祝你好运！";
    }


    @RequestMapping("/testGet10")
    public ResultInfo testGet10() {

        ResultInfo resultInfo = myTeacherServiceApi
                .insertBatch2(Stream.of(new MyTeacher()).collect(Collectors.toList()));

        return resultInfo;
    }

    @PostMapping("/insertTeacher")
    public ResultInfo insertTeacher(MyTeacher myTeacher) {
        myTeacher.setId(ThreadLocalRandom.current().nextLong(100,999999999L));
        return myTeacherServiceApi.insert2(myTeacher);
    }

}