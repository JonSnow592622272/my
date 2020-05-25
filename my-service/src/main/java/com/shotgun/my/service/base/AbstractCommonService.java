package com.shotgun.my.service.base;

import com.shotgun.my.api.consts.MyCodeEnum;
import com.shotgun.mycommon.base.base.api.ResultInfo;
import com.shotgun.mycommon.service.base.AbstractBombService;
import com.shotgun.mycommon.service.base.BombMapper;

/**
 * @author wulm
 **/
public abstract class AbstractCommonService<M extends BombMapper<T>, T> extends AbstractBombService<M, T> implements CommonService<T> {

    @Override
    public ResultInfo success() {
        return ResultInfo.of(MyCodeEnum.SUCCESS);
    }
}
