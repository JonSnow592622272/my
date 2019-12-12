package com.shotgun.my.service.service;

import com.shotgun.my.api.api.UserServiceApi;
import com.shotgun.my.api.consts.CommonConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @desc 提供给controller层的接口放在Api接口，仅给service层提供的接口才放到这
 **/
@FeignClient(name = CommonConstant.APPLICATION_NAME)
public interface UserService extends UserServiceApi {


}