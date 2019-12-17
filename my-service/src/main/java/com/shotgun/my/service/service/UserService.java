package com.shotgun.my.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shotgun.my.api.api.UserServiceApi;
import com.shotgun.my.api.po.pojos.User;

/**
 * @desc 提供给controller层的接口放在Api接口，仅给service层提供的接口才放到这
 **/
public interface UserService extends UserServiceApi, IService<User> {


}