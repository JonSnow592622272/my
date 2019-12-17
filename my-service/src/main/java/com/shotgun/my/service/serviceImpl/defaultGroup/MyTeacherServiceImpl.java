package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyTeacher;
import com.shotgun.my.service.dao.defaultGroup.MyTeacherMapper;
import com.shotgun.my.service.service.defaultGroup.MyTeacherService;
import com.shotgun.mycommon.service.base.MyServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MyTeacherServiceApi.PATH)
public class MyTeacherServiceImpl extends MyServiceImpl<MyTeacherMapper, MyTeacher> implements MyTeacherService {

    /**
     * 暴露接口
     **/
    @Override
    public IPage<MyTeacher> testGet10() {
        return super.testGet10();
    }


}
