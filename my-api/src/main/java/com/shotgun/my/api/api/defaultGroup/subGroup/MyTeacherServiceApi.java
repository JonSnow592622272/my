package com.shotgun.my.api.api.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.config.FeignConfig;
import com.shotgun.my.api.consts.CommonConstant;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.mycommon.base.base.Goups;
import com.shotgun.mycommon.base.base.ResultInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wulm
 **/
@FeignClient(name = CommonConstant.APPLICATION_SERVICE_NAME, contextId = "myTeacherServiceApi", path =
        CommonConstant.APPLICATION_SERVICE_SERVLET_CONTEXT_PATH + MyTeacherServiceApi.PATH, configuration =
        FeignConfig.class)
public interface MyTeacherServiceApi {
    String PATH = "/my_teacher";

    @GetMapping("/testGet10")
    IPage<MyTeacher> testGet10();

    @PostMapping("/insert")
    @Validated(Goups.Insert.class)
    ResultInfo insert(MyTeacher record);



}