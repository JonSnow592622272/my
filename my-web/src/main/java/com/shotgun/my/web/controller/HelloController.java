package com.shotgun.my.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.api.defaultGroup.subGroup.TestBbbServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
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
public class HelloController {

    @Autowired
    private TestBbbServiceApi testBbbService;

    @Autowired
    private MyTeacherServiceApi myTeacherServiceApi;

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insert")
    public ResultInfo insert(MyTeacher myTeacher) {
        return myTeacherServiceApi.insert(myTeacher);
    }

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insertBatch")
    public ResultInfo insertBatch(MyTeacher myTeacher) {
        return myTeacherServiceApi.insertBatch(myTeacher);
    }

    /**
     * api基础接口测试
     *
     * @author wulm
     **/
    @PostMapping("insertBatch2")
    public ResultInfo insertBatch(@RequestBody List<MyTeacher> myTeachers) {
        return myTeacherServiceApi.insertBatch(myTeachers);
    }

    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());


        IPage<MyTeacher> myTeacherIPage = myTeacherServiceApi.testGet102("aaa", "bbbbbbbbbbbbbbbbbbbb");
        return "Greetings from Spring Boot! 祝你好运！";
    }


    @RequestMapping("/testGet10")
    public ResultInfo testGet10(MyTeacher myTeacher) {
        ResultInfo resultInfo = myTeacherServiceApi.insertBatch2(getTeachers());

        return resultInfo;
    }

    @PostMapping("/insertTeacher")
    public ResultInfo insertTeacher(MyTeacher myTeacher) {
        return myTeacherServiceApi.insert2(myTeacher);
    }

    @PostMapping("/baseInsert66666")
    public ResultInfo baseInsert66666(MyTeacher myTeacher) {
        return myTeacherServiceApi.baseInsert66666(myTeacher);
    }

    @PostMapping("/insertBatch77777")
    public ResultInfo insertBatch77777(MyTeacher myTeacher) {

        return myTeacherServiceApi.insertBatch77777(getTeachers());
    }

    public static List<MyTeacher> getTeachers() {
        List<MyTeacher> list = IntStream.range(1, 6).mapToObj(operand -> {
            MyTeacher t = new MyTeacher();
            t.setName("张三让我恩服务费");
            t.setAge(operand);
            return t;
        }).collect(Collectors.toList());
        return list;
    }

}