package com.shotgun.my.api.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "TestBbbApi", url = "https://www.baidu.com")
@RequestMapping(value = "/test222")
public interface TestBbbService {

    @PostMapping("/bb")
    String bb();

}