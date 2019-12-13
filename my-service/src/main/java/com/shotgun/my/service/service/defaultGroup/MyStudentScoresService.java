package com.shotgun.my.service.service.defaultGroup;

import com.shotgun.my.api.api.defaultGroup.MyStudentScoresServiceApi;
import com.shotgun.my.api.po.pojos.defaultGroup.MyStudentScores;
import com.shotgun.mycommon.service.base.MyIService;

/**
 * @desc 提供给controller层的接口放在Api接口，仅给service层提供的接口才放到这
 **/
public interface MyStudentScoresService extends MyStudentScoresServiceApi, MyIService<MyStudentScores>  {


}