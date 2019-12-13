package com.shotgun.my.service.service.defaultGroup;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shotgun.my.api.api.defaultGroup.MyStudentServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudent;

/**
 * @desc 提供给controller层的接口放在Api接口，仅给service层提供的接口才放到这
 **/
public interface MyStudentService extends MyStudentServiceApi, IService<MyStudent> {


}