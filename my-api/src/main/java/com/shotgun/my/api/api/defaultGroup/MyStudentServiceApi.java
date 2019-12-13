package com.shotgun.my.api.api.defaultGroup;

import com.shotgun.my.api.consts.CommonConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = CommonConstant.APPLICATION_NAME)
@RequestMapping(MyStudentServiceApi.PATH)
public interface MyStudentServiceApi {
    String PATH = "/my_student";


}