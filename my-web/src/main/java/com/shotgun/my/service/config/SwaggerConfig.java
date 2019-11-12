package com.shotgun.my.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问页面为
 * 原swagger页面：http://localhost:8000/swagger-ui.html
 * 第三方swagger页面：http://localhost:8000/doc.html
 *
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("配置管理wwwwwwwww").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.shotgun.my.web.controller")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("xxxxxxxxxxxxxxxx maven构建Spring boot项目")
                .description("aaaaa maven构建Spring boot项目")
//                .termsOfServiceUrl("http://www.baidu.com")
                .version("1.0").build();
    }

}
