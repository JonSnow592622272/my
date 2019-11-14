package com.shotgun.my.web.controller;

import com.shotgun.my.api.api.TestBbbApi;
import com.shotgun.my.api.api.UserService;
import com.shotgun.my.api.po.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    TestBbbApi testBbbApi;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbApi.bb());

        List<User> onelalala = userService.getOnelalala();
        System.out.println(onelalala);

        return "Greetings from Spring Boot! 祝你好运！";
    }

}