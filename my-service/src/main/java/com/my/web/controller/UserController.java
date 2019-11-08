package com.my.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.api.basedo.User;
import com.my.common.util.LogUtils;
import com.my.service.dao.defaultDb.UserMapper;
import com.my.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("")
    public String index() {

        logger.debug("lslsllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");

        LogUtils.getLogger().debug("jjjjjjjiwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwooooooooooopppppppppp");
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.selectList();
        userList.forEach(System.out::println);

        List<User> list = userService.getOnelalala(new Page(2, 2));

        list.forEach(user -> {
            System.out.println(user.getName() + ":::" + user.getEmail());
        });

        return "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    }

    @RequestMapping("testD")
    public String testD() {

        List<User> aaa = userMapper.test();

        aaa.forEach(user -> {
            System.out.println(user.getName() + ":::" + user.getEmail());
        });

        List<User> users = userService.testHaha();
        users.forEach(user -> {
            System.out.println(user.getName() + ":::" + user.getEmail());
        });


        return "fffffffffffffffffffffff";
    }

}