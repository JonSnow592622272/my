package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.shotgun.my.api.api.defaultGroup.MyStudentServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudent;
import com.shotgun.my.service.dao.defaultGroup.MyStudentMapper;
import com.shotgun.my.service.service.defaultGroup.MyStudentService;
import com.shotgun.mycommon.service.base.MyServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MyStudentServiceApi.PATH)
public class MyStudentServiceImpl extends MyServiceImpl<MyStudentMapper, MyStudent> implements MyStudentService {


}
