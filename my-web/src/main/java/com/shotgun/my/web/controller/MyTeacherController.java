package com.shotgun.my.web.controller;

import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.mycommon.base.base.api.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wulm
 **/
@RestController
//@RequestMapping("myteacher")
public class MyTeacherController {

    @Autowired
    private MyTeacherServiceApi MyTeacherServiceApi;

    /**
     * api基础接口测试
     **/
    @PostMapping("insert")
    public ResultInfo insert(MyTeacher myTeacher) {
        return MyTeacherServiceApi.insert(myTeacher);
    }

    /**
     * api基础接口测试
     **/
    @PostMapping("insertBatchArr")
    public ResultInfo insertBatchArr(MyTeacher myTeacher) {
        return MyTeacherServiceApi.insertBatch(myTeacher);
    }

    /**
     * api基础接口测试
     **/
    @PostMapping("insertBatchCol")
    public ResultInfo insertBatchCol(@RequestBody List<MyTeacher> myTeachers) {
        return MyTeacherServiceApi.insertBatch(myTeachers);
    }


}