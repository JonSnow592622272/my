package com.shotgun.my.service.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shotgun.my.api.api.UserServiceApi;
import com.shotgun.my.api.po.pojos.User;
import com.shotgun.my.service.dao.defaultDb.UserMapper;
import com.shotgun.my.service.service.UserService;
import com.shotgun.mycommon.service.base.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DS("db2")//切换数据源
@RestController
public class UserServiceImpl extends MyServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserServiceApi userService;

    @Override
    public List<User> getOnelalala() {

        userService.testAdd();

        System.out.println("lllllllllllllllllllllllll" + userService.selectList());

        return super.getBaseMapper().getOnelalala(new Page(1, 5));
    }

    @Override
    public List<User> selectList() {
        return super.getBaseMapper().selectList(null);
    }

    @Transactional
    @Override
    public void testAdd() {
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextLong());
        super.save(user);

        System.out.println("add1111111111111111111111111");
    }

}
