package com.shotgun.my.service.service.defaultGroup.subGroup;

import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyTeacher;
import com.shotgun.mycommon.service.base.MyIService;

/**
 * @author wulm
 * 只提供给service层的接口才放到这里(controller无法访问到)，提供给controller层的接口放在ServiceApi接口
 **/
public interface MyTeacherService extends MyTeacherServiceApi, MyIService<MyTeacher> {


}