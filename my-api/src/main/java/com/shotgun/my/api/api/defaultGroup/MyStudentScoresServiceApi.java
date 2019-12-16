package com.shotgun.my.api.api.defaultGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.consts.CommonConstant;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudentScores;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = CommonConstant.APPLICATION_NAME)
@RequestMapping(MyStudentServiceApi.PATH)
public interface MyStudentScoresServiceApi {
    String PATH = "/my_student_scores";

    @GetMapping("/testGet10")
    IPage<MyStudentScores> testGet10();


}