package com.shotgun.my.api.api.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.config.FeignConfig;
import com.shotgun.my.api.consts.CommonConstant;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = CommonConstant.APPLICATION_SERVICE_NAME, contextId = "myTeacherServiceApi", path =
        CommonConstant.APPLICATION_SERVICE_SERVLET_CONTEXT_PATH + MyTeacherServiceApi.PATH, configuration =
        FeignConfig.class)
public interface MyTeacherServiceApi {
    String PATH = "/my_teacher";

    @GetMapping("/testGet10")
    IPage<MyTeacher> testGet10();


}