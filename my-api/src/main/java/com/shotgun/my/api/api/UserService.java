package com.shotgun.my.api.api;

import com.shotgun.my.api.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "my-service")
public interface UserService {

    @GetMapping("/")
    List<User> getOnelalala();

    @GetMapping("/a")
    List<User> selectList();
}