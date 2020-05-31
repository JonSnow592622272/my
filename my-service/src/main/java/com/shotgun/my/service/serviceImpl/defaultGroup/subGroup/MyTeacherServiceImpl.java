package com.shotgun.my.service.serviceImpl.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.my.service.base.AbstractCommonService;
import com.shotgun.my.service.dao.defaultGroup.subGroup.MyTeacherMapper;
import com.shotgun.my.service.service.defaultGroup.subGroup.MyTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wulm
 * 当service方法和ServiceApi方法有重载方法时，应当用api的实现方法调用service的实现方法，具体验证逻辑写在service中，相当于serviceApi是controller，封装更多。
 **/
@RestController
@RequestMapping(MyTeacherServiceApi.PATH)
public class MyTeacherServiceImpl extends AbstractCommonService<MyTeacherMapper, MyTeacher> implements MyTeacherService {

    /**
     * http接口调用
     */
    private MyTeacherServiceApi myTeacherServiceApi;

    /**
     * 内部方法直接调用
     */
    private MyTeacherService myTeacherService;

    @Autowired
    public void setMyTeacherServiceApi(MyTeacherServiceApi myTeacherServiceApi) {
        this.myTeacherServiceApi = myTeacherServiceApi;
    }

    @Autowired
    @Lazy
    public void setMyTeacherService(MyTeacherService myTeacherService) {
        this.myTeacherService = myTeacherService;
    }


    /**
     * service-controller暴露接口，不重写则不暴露出去
     *
     * @param a
     * @param b
     */
    @Override
    public IPage<MyTeacher> testGet102(String a, String b) {


        System.out.println("class信息：：：："+this.getClass().getName());
        System.out.println("testServiceApi内存信息:::" + myTeacherServiceApi);
        System.out.println("testService内存信息:::" + myTeacherService);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa::::::::::::::::::::::::::::::::::::::::" + a);
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb::::::::::::::::::::::::::::::::::::::::" + b);

        return super.baseTestGet10(a, b);
    }



}
