package com.shotgun.my.service.service.defaultGroup;

import com.shotgun.my.api.api.defaultGroup.MyStudentServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudent;
import com.shotgun.mycommon.service.base.MyIService;

/**
 * @desc 提供给controller层的接口放在Api接口，仅给service层提供的接口才放到这
 **/
public interface MyStudentService extends MyStudentServiceApi, MyIService<MyStudent>  {


}