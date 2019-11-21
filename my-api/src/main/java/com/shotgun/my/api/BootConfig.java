package com.shotgun.my.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/** 将配置文件读取到spring环境中 */
@PropertySource("classpath:/feign-${spring.profiles.active}.properties")
@Configuration
public class BootConfig {

}