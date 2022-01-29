package com.ujs.iot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2 //开启在线文档
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                .apis(RequestHandlerSelectors.basePackage("com.ujs.iot.Controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工业物联网课设")        //api文档名字
                .description("2021.12.27启动")   //api名字
                .termsOfServiceUrl("http://blog.csdn.net/forezp")  //附带链接资源
                .version("1.0")
                .build();
    }
}