package com.shotgun.my.service.serviceImpl.defaultGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.api.defaultGroup.MyStudentScoresServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudentScores;
import com.shotgun.my.service.dao.defaultGroup.MyStudentScoresMapper;
import com.shotgun.my.service.service.defaultGroup.MyStudentScoresService;
import com.shotgun.mycommon.service.base.MyServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MyStudentScoresServiceApi.PATH)
public class MyStudentScoresServiceImpl extends MyServiceImpl<MyStudentScoresMapper, MyStudentScores> implements MyStudentScoresService {


    public void a() {
        IPage<MyStudentScores> myStudentScoresIPage = testGet10();
    }

}
