package com.shotgun.my.api.api.defaultGroup;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shotgun.my.api.consts.CommonConstant;
import com.shotgun.my.api.po.pojos.defaultGroup.MyTeacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = CommonConstant.APPLICATION_NAME, contextId = "myTeacherServiceApi", path = CommonConstant.APPLICATION_SERVLET_CONTEXT_PATH + MyTeacherServiceApi.PATH)
public interface MyTeacherServiceApi {
    String PATH = "/my_teacher";

    @GetMapping("/testGet10")
    Page<MyTeacher> testGet10();


}