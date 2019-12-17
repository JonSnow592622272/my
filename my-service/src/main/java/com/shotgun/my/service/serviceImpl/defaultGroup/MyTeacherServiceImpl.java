package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shotgun.my.api.api.UserServiceApi;
import com.shotgun.my.api.api.defaultGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyTeacher;
import com.shotgun.my.service.dao.defaultGroup.MyTeacherMapper;
import com.shotgun.my.service.service.defaultGroup.MyTeacherService;
import com.shotgun.mycommon.service.base.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MyTeacherServiceApi.PATH)
public class MyTeacherServiceImpl extends MyServiceImpl<MyTeacherMapper, MyTeacher> implements MyTeacherService {

    @Autowired
    private MyTeacherServiceApi myTeacherServiceApi;

    @Autowired
    private UserServiceApi userServiceApi;

    @Autowired
    private UserServiceApi userService;


    /**
     * 暴露接口
     **/
    @Override
    public Page<MyTeacher> testGet10() {
        return super.testGet10();
    }

    @GetMapping("/testGet101")
    public IPage<MyTeacher> testGet101() {
        System.out.println(userServiceApi);
        System.out.println(userService);

        Page<MyTeacher> myTeacherIPage = myTeacherServiceApi.testGet10();
        return myTeacherIPage;
    }

}
