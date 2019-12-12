package com.shotgun.my.web.controller;

import com.shotgun.my.api.api.TestBbbService;
import com.shotgun.my.api.api.UserServiceApi;
import com.shotgun.my.api.po.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    TestBbbService testBbbService;

    @Autowired
    UserServiceApi userService;

    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());

        List<User> onelalala = userService.getOnelalala();
        System.out.println(onelalala);

        return "Greetings from Spring Boot! 祝你好运！";
    }

}