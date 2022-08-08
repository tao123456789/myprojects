package com.example.MQService.Utils.CommonUtil;

import com.example.MQService.Entity.PO.EmailPO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MQUtil {
    @Resource
    AmqpTemplate rabbitTemplate;

    public void SendEmailMQ(String Queues, EmailPO emailPO) {
        System.out.println("向"+Queues+"队列发送数据："+emailPO.toString());
        this.rabbitTemplate.convertAndSend(Queues, emailPO);
    }
}
