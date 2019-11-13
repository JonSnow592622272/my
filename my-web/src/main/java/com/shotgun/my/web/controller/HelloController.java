package com.shotgun.my.web.controller;

import com.shotgun.my.api.api.TestBbbApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    TestBbbApi testBbbApi;

    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbApi.bb());

        return "Greetings from Spring Boot! 祝你好运！";
    }

}