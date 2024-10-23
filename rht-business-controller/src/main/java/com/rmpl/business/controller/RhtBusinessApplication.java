package com.rmpl.business.controller;


//import com.rmpl.order.properties.OrderChannel;
import com.rmpl.business.common.properties.OrderChannel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;


/**
 * @desc 功能描述: 启动主类
 * @author: muxh
 * @date: 2021/08/23
 */
@SpringBootApplication(scanBasePackages = "com.rmpl.business")
@EnableDiscoveryClient
@MapperScan(basePackages = "com.rmpl.business.domain.infrastructure.*")
@EnableFeignClients(basePackages = {"com.rmpl.business.spi.*","com.rmpl.basic.**.client","com.rmpl.goods.goods.client"})
@EnableBinding(OrderChannel.class)
public class RhtBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(RhtBusinessApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //指定文件代销
        factory.setMaxFileSize(DataSize.parse("100MB"));
        /// 设定上传文件大小
        factory.setMaxRequestSize(DataSize.parse("100MB"));
        return factory.createMultipartConfig();
    }
}
