package com.my.service.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.api.basedo.User;
import com.my.service.dao.defaultDb.UserMapper;
import com.my.service.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DS("db2")//切换数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getOnelalala(Page page) {
        return userMapper.getOnelalala(page);
    }

    @Override
    public List<User> selectList() {
        return userMapper.selectList(null);
    }

}
