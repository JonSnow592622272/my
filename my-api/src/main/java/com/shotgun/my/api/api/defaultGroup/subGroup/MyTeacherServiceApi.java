package com.shotgun.my.api.api.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.config.FeignConfig;
import com.shotgun.my.api.consts.CommonConstant;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.mycommon.base.base.Goups;
import com.shotgun.mycommon.base.base.ResultInfo;
import org.hibernate.validator.constraints.Length;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author wulm
 * 方法命名规范：增删改查：insert,update,delete,get
 **/
@FeignClient(name = CommonConstant.APPLICATION_SERVICE_NAME, contextId = "myTeacherServiceApi", path =
        CommonConstant.APPLICATION_SERVICE_SERVLET_CONTEXT_PATH + MyTeacherServiceApi.PATH, configuration =
        FeignConfig.class)
@Validated
public interface MyTeacherServiceApi {
    String PATH = "/my_teacher";


    @GetMapping("/testGet10")
    IPage<MyTeacher> testGet102(@RequestParam @Length(max = 4, message = "长度不能大于4") String a,
            @RequestParam String b);

    @PostMapping("/insert")
    @Validated(Goups.Insert.class)
    ResultInfo insert2(@RequestBody @Valid MyTeacher record);


}