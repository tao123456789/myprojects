package com.example.MQService.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureRabbit {
    @Bean
    public Queue MessageQueue() {
        return new Queue("EmailMessage"); //配置一个名称为"EmailMessage"的Queue队列
    }
}
