package com.shotgun.my.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shotgun.my.api.api.UserService;
import com.shotgun.my.api.po.pojos.User;
import com.shotgun.my.service.dao.defaultDb.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@DS("db2")//切换数据源
@RestController
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getOnelalala() {
        return userMapper.getOnelalala(new Page(1, 5));
    }

    @Override
    public List<User> selectList() {
        return userMapper.selectList(null);
    }

}
