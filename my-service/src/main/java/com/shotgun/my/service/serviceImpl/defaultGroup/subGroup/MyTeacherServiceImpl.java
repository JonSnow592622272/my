package com.shotgun.my.service.serviceImpl.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.my.service.dao.defaultGroup.subGroup.MyTeacherMapper;
import com.shotgun.my.service.service.defaultGroup.subGroup.MyTeacherService;
import com.shotgun.mycommon.service.base.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wulm
 **/
@RestController
@RequestMapping(MyTeacherServiceApi.PATH)
public class MyTeacherServiceImpl extends MyServiceImpl<MyTeacherMapper, MyTeacher> implements MyTeacherService {

    /**
     * http接口调用
     */
    @Autowired
    private MyTeacherServiceApi testServiceApi;

    /**
     * 内部方法直接调用
     */
    @Autowired
    private MyTeacherService testService;


    /**
     * service-controller暴露接口
     **/
    @Override
    public IPage<MyTeacher> testGet10() {


        System.out.println("testServiceApi内存信息:::" + testServiceApi);
        System.out.println("testService内存信息:::" + testService);

        return super.testGet10();
    }


}
