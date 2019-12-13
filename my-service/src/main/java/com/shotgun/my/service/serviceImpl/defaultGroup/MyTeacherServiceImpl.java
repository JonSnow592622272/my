package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shotgun.my.api.api.defaultGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyTeacher;
import com.shotgun.my.service.dao.defaultGroup.MyTeacherMapper;
import com.shotgun.my.service.service.defaultGroup.MyTeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MyTeacherServiceApi.PATH)
public class MyTeacherServiceImpl extends ServiceImpl<MyTeacherMapper, MyTeacher> implements MyTeacherService {


}
