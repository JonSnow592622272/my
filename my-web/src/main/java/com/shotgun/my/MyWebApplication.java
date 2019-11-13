package com.shotgun.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@EnableFeignClients
@SpringBootApplication
public class MyWebApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MyWebApplication.class, args);

//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

}

