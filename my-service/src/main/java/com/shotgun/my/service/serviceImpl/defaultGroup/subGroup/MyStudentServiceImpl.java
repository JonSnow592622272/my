package com.shotgun.my.service.serviceImpl.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.subGroup.MyStudentServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyStudent;
import com.shotgun.my.service.base.AbstractCommonService;
import com.shotgun.my.service.dao.defaultGroup.subGroup.MyStudentMapper;
import com.shotgun.my.service.service.defaultGroup.subGroup.MyStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wulm
 * 当service方法和ServiceApi方法有重载方法时，应当用api的实现方法调用service的实现方法，具体验证逻辑写在service中，相当于serviceApi是controller，封装更多。
 **/
@RestController
@RequestMapping(MyStudentServiceApi.PATH)
public class MyStudentServiceImpl extends AbstractCommonService<MyStudentMapper, MyStudent> implements MyStudentService {

    /**
     * http接口调用
     */
    private MyStudentServiceApi myStudentServiceApi;

    /**
     * 内部方法直接调用
     */
    private MyStudentService myStudentService;

    @Autowired
    public void setMyStudentServiceApi(MyStudentServiceApi myStudentServiceApi) {
        this.myStudentServiceApi = myStudentServiceApi;
    }

    @Autowired
    @Lazy
    public void setMyStudentService(MyStudentService myStudentService) {
        this.myStudentService = myStudentService;
    }


    /**
     * service-controller暴露接口，不重写则不暴露出去
     *
     * @param a
     * @param b
     */
    @Override
    public IPage<MyStudent> testGet102(String a, String b) {


        System.out.println("class信息：：：："+this.getClass().getName());
        System.out.println("testServiceApi内存信息:::" + myStudentServiceApi);
        System.out.println("testService内存信息:::" + myStudentService);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa::::::::::::::::::::::::::::::::::::::::" + a);
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb::::::::::::::::::::::::::::::::::::::::" + b);

        return super.baseTestGet10(a, b);
    }


}
