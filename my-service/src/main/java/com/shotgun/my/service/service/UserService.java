package com.shotgun.my.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shotgun.my.service.api.User;

import java.util.List;

/**
 * @author wulm
 * @date 2019/7/23 15:34
 * @version 1.0.0
 * @desc
 */
public interface UserService extends MyBaseService<User> {

    List<User> getOnelalala(Page page);

    List<User> selectList();
}