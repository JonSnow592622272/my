package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudent;
import com.shotgun.my.service.dao.defaultGroup.MyStudentMapper;
import com.shotgun.my.service.service.defaultGroup.MyStudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xxx")
public class MyStudentServiceImpl extends ServiceImpl<MyStudentMapper, MyStudent> implements MyStudentService {


}
