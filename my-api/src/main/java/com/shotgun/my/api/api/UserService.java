package com.shotgun.my.api.api;

import com.shotgun.my.api.po.pojos.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "my-service")
public interface UserService {

    @GetMapping("/getOnelalala")
    List<User> getOnelalala();

    @GetMapping("/selectList")
    List<User> selectList();
}