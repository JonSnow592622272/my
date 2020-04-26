package com.shotgun.my.service.service.defaultGroup.subGroup;

import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;

/**
 * 只提供给service层的接口才放到这里(controller无法访问到)，提供给controller层的接口放在ServiceApi接口
 **/
public interface MyTeacherService extends MyTeacherServiceApi/*, MyIService<MyTeacher>注释是为了只允许当前实现类调用里面的方法，避免其他service实现类调用里面的方法来绕过逻辑验证，*/  {


}