package com.shotgun.my.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shotgun.my.api.api.UserService;
import com.shotgun.my.api.api.UserService.UserServiceExt;
import com.shotgun.my.api.po.pojos.User;
import com.shotgun.my.service.dao.defaultDb.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DS("db2")//切换数据源
@RestController
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserServiceExt {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userServiceExt;

    @Override
    public List<User> getOnelalala() {

        userServiceExt.testAdd();

        System.out.println("lllllllllllllllllllllllll" + userServiceExt.selectList());

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
