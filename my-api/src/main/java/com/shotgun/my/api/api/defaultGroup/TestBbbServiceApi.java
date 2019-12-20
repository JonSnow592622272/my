package com.shotgun.my.api.api.defaultGroup;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "TestBbbApi", url = "${feign.baidu.url}")
@RequestMapping(value = "/test222")
public interface TestBbbServiceApi {

    @PostMapping("/bb")
    String bb();

}