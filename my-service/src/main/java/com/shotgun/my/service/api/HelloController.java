package com.shotgun.my.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(String[] a) {
        System.out.println(Arrays.toString(a));
        return "Greetings from Spring Boot! 祝你好运！";
    }

}