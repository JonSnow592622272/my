package com.shotgun.my.api.api.defaultGroup.subGroup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shotgun.my.api.config.FeignConfig;
import com.shotgun.my.api.consts.CommonConstant;
import com.shotgun.my.api.po.pojos.defaultGroup.subGroup.MyStudent;
import com.shotgun.mycommon.base.base.api.BombApi;
import com.shotgun.mycommon.base.base.api.ResultInfo;
import com.shotgun.mycommon.base.base.valid.Goups;
import org.hibernate.validator.constraints.Length;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author wulm
 * 方法命名规范：增删改查：insert,update,delete,get
 * <p>
 * 后面增加mq异步处理，1：web发起feign调用，service的feign中spring验证器验证数据后，发送消息到消息中间件，当前service消费消息，从spring中拿到实现类执行逻辑
 **/
@FeignClient(name = CommonConstant.APPLICATION_SERVICE_NAME, contextId = "myStuServiceApi", path =
        CommonConstant.APPLICATION_SERVICE_SERVLET_CONTEXT_PATH + MyStudentServiceApi.PATH, configuration =
        FeignConfig.class)
@Validated
public interface MyStudentServiceApi extends BombApi<MyStudent> {
    String PATH = "/my_stu";


    @GetMapping("/testGet10")
    IPage<MyStudent> testGet102(@RequestParam @Length(max = 4, message = "长度不能大于{max}") String a,
            @RequestParam String b);

    @PostMapping("/insert2")
    @Validated(Goups.Insert.class)
    ResultInfo insert2(@RequestBody @Valid MyStudent record);

}