package com.shotgun.my.api.api.defaultGroup.subGroup;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "TestBbbApi", url = "${feign.baidu.url}")
public interface TestBbbServiceApi {

    @PostMapping("/bb")
    String bb();

}