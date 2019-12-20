package com.shotgun.my.web.controller;

import com.shotgun.my.api.api.defaultGroup.TestBbbServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    TestBbbServiceApi testBbbService;


    @RequestMapping("/")
    public String index() {
        System.out.println(testBbbService.bb());

        return "Greetings from Spring Boot! 祝你好运！";
    }

}