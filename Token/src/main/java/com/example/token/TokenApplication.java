package com.example.token;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = {"com.example.token","com.example.common.Mapper"})
@EnableSwagger2
@EnableAsync
public class TokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(TokenApplication.class, args);
    }
}
