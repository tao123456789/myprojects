package com.example.MQService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = {"com.example.MQService.Mapper"})
public class MQServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MQServiceApplication.class, args);
    }
}
