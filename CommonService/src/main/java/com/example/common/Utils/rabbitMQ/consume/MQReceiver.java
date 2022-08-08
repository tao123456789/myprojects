package com.example.common.Utils.rabbitMQ.consume;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.common.Utils.rabbitMQ.QQEmailUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "EmailMessage")
public class MQReceiver {
    @Autowired
    QQEmailUtils qqEmailUtils;

    @RabbitHandler
    public void SendEmailMQ(EmailPO emailPO) throws Exception {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("收到MQ消息 : " + emailPO.getContent());
        try {
            qqEmailUtils.SendToByQQEmail(emailPO);
        }catch (Exception e){
            emailPO.setToEmail("2413629661@qq.com");
            emailPO.setSubject("【邮件发送失败通知】");
            emailPO.setContent("发送至"+emailPO.getToEmail()+"的邮件发送失败");
            qqEmailUtils.SendToByQQEmail(emailPO);
        }
        System.out.println("---------------------------------------------------------------------");
    }
    @RabbitHandler
    public void SendEmailMQ(String context) throws Exception {
        System.out.println("消费MQ队列："+context);
    }
}
