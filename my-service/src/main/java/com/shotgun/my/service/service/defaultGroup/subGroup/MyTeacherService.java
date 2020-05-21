package com.shotgun.my.service.service.defaultGroup.subGroup;

import com.shotgun.my.api.api.defaultGroup.subGroup.MyTeacherServiceApi;

/**
 * @author wulm
 * 只提供给service层的接口才放到这里(controller无法访问到)，提供给controller层的接口放在ServiceApi接口
 * 避免重复定义相同功能接口，比如xxxServiceApi定义批量新增方法1，Service也定义批量新增方法2。此时Service拥有两个批量新增方法，可以去除Service中的接口，仅保留Api中的接口。
 **/
public interface MyTeacherService extends MyTeacherServiceApi {


}