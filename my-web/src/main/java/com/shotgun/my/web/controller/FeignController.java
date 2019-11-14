package com.shotgun.my.web.controller;

import com.shotgun.my.api.api.UserService;
import com.shotgun.my.api.po.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wocao")
public class FeignController {

    @Autowired
    private UserService userService;

    @RequestMapping("/a")
    public List<User> a() {

        return userService.getOnelalala();
    }

    @RequestMapping("/a2")
    public List<User> a2() {

        return userService.selectList();
    }

}