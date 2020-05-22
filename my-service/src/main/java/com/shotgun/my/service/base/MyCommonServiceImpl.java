package com.shotgun.my.service.base;

import com.shotgun.my.api.consts.MyCodeEnum;
import com.shotgun.mycommon.base.base.ResultInfo;
import com.shotgun.mycommon.service.base.AbstractCommonService;
import com.shotgun.mycommon.service.base.MyBaseMapper;

/**
 * @author wulm
 * 所有serviceImpl的基类，用于存放公共基础方法。不能在XXXServiceApi中创建与当该类方法同名接口，否则会引起feign的验证问题
 **/
public class MyCommonServiceImpl<M extends MyBaseMapper<T>, T> extends AbstractCommonService<M, T> implements MyCommonService<T> {

    @Override
    protected ResultInfo success() {
        return ResultInfo.of(MyCodeEnum.SUCCESS);
    }
}
