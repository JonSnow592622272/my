package com.shotgun.my.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.api.defaultGroup.subGroup.TestBbbServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.mycommon.base.base.api.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


        IPage<MyTeacher> myTeacherIPage = myTeacherServiceApi.testGet102("aaa", "bbbbbbbbbbbbbbbbbbbb");
        return "Greetings from Spring Boot! 祝你好运！";
    }


    @RequestMapping("/testGet10")
    public ResultInfo testGet10(MyTeacher myTeacher) {
        myTeacher.setId(ThreadLocalRandom.current().nextLong(100, 999999999L));

        ResultInfo resultInfo = myTeacherServiceApi.insertBatch2(getTeachers());

        return resultInfo;
    }

    @PostMapping("/insertTeacher")
    public ResultInfo insertTeacher(MyTeacher myTeacher) {
        myTeacher.setId(ThreadLocalRandom.current().nextLong(100, 999999999L));
        return myTeacherServiceApi.insert2(myTeacher);
    }

    @PostMapping("/baseInsert66666")
    public ResultInfo baseInsert66666(MyTeacher myTeacher) {
        myTeacher.setId(ThreadLocalRandom.current().nextLong(100, 999999999L));
        return myTeacherServiceApi.baseInsert66666(myTeacher);
    }

    @PostMapping("/insertBatch77777")
    public ResultInfo insertBatch77777(MyTeacher myTeacher) {

        return myTeacherServiceApi.insertBatch77777(getTeachers());
    }

    public static List<MyTeacher> getTeachers() {
        List<MyTeacher> list = IntStream.range(1, 6).mapToObj(operand -> {
            MyTeacher t = new MyTeacher();
            t.setId(ThreadLocalRandom.current().nextLong(100, 999999999L));
            t.setName("张三让我恩服务费");
            t.setAge(operand);
            return t;
        }).collect(Collectors.toList());
        return list;
    }

}