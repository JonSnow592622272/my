package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shotgun.my.api.api.defaultGroup.MyStudentScoresServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudentScores;
import com.shotgun.my.service.dao.defaultGroup.MyStudentScoresMapper;
import com.shotgun.my.service.service.defaultGroup.MyStudentScoresService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MyStudentScoresServiceApi.PATH)
public class MyStudentScoresServiceImpl extends ServiceImpl<MyStudentScoresMapper, MyStudentScores> implements MyStudentScoresService {


}
