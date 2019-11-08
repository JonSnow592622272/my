package com.my.service.dao.defaultDb;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.api.basedo.User;
import com.my.service.dao.MyBaseMapper;
import java.util.List;

/**
 * @author wulm
 * @version 1.0.0
 * @date 2019/7/23 15:34
 * @desc
 */
public interface UserMapper extends MyBaseMapper<User> {

    List<User> getOnelalala(Page page);
}