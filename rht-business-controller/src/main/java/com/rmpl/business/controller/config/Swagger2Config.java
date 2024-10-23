package com.rmpl.business.controller.config;


import com.rmpl.business.common.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/**
 * Swagger2 配置
 *
 * @author muxh
 */

@Profile("!prod")
@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config {

    @Bean
    public Docket docket() {
        List<Parameter> list = Arrays.asList(
                new ParameterBuilder().name(GlobalConstant.ACCESS_TOKEN).description("Authorization token | 登录token")
                        .modelRef(new ModelRef("string")).parameterType("header").build(),
                new ParameterBuilder().name("userId").description("用户ID")
                        .modelRef(new ModelRef("long")).parameterType("header").build());
        return new Docket(DocumentationType.SWAGGER_2)  //设置文档类型
                //api的相关描述信息，通常显示在页面的最上方
                .globalOperationParameters(list)
                .apiInfo(apiInfo()).select()
                //设置扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.rmpl.business.controller.http"))
                //设置扫描哪些controller，这里设置扫描全部，可以传入正则表达式
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("rht-business").description("订单中心").contact("穆晓辉").version("1.0").build();
    }

    @Profile("prod")
    @RestController
    public static class SwaggerController {
        @RequestMapping("/swagger-ui.html")
        public String swaggerUI() {
            return "404";
        }

        @RequestMapping("/doc.html")
        public String doc() {
            return "404";
        }
    }
}
