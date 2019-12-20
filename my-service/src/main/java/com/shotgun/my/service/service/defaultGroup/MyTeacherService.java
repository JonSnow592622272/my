package com.shotgun.my.service.service.defaultGroup;

import com.shotgun.my.api.api.defaultGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyTeacher;
import com.shotgun.mycommon.service.base.MyIService;

/**
 * @desc 只提供给service层的接口才放到这里，提供给controller层的接口放在ServiceApi接口
 **/
public interface MyTeacherService extends MyTeacherServiceApi, MyIService<MyTeacher>  {


}