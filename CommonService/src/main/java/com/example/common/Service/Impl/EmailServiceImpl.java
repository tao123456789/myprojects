package com.example.common.Service.Impl;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.common.feign.EmailMQFeign;
import com.example.common.Entity.BO.subscriber.SubscriberBO;
import com.example.common.Mapper.SubscriberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmailServiceImpl {
    @Resource
    SubscriberMapper subscriberMapper;
    @Resource
    private EmailMQFeign emailMQFeign;

    //推送订阅者邮件
    public void SendMessageToSubscriberBYMQ(String type,String tittle,String content) throws Exception {
        List<SubscriberBO> subscriberBOList=subscriberMapper.getSubscriberByType(type);
        for(SubscriberBO subscriberBO:subscriberBOList) {
            EmailPO emailPO =new EmailPO();
            emailPO.setToEmail(subscriberBO.getRemark());
            emailPO.setTitle(tittle);
            emailPO.setContent(content);
            System.out.println("发送： "+subscriberBO.getName()+"  邮件，账号为： "+subscriberBO.getRemark()+" ，内容为： "+content);
            emailMQFeign.emailSendByQQMail(emailPO);
            //邮件直接发送
            //qqEmailUtils.SendToByQQ(tittle, content, subscriberBO.getMessage());
        }
    }

    //推送单个邮箱
    public void SendWBMessageToOneBYMQ(String tittle,String content,String ToEMail) throws Exception {
        EmailPO emailPO =new EmailPO();
        emailPO.setToEmail(ToEMail);
        emailPO.setTitle(tittle);
        emailPO.setContent(content);
        System.out.println("发送： "+ToEMail+"  邮件，账号为： "+ToEMail+" ，内容为： "+content);
        emailMQFeign.emailSendByQQMail(emailPO);
        //邮件直接发送
        //qqEmailUtils.SendToByQQ(tittle, content, subscriberBO.getMessage());
    }
}
