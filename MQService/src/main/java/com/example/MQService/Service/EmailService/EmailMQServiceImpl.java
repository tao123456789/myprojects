package com.example.MQService.Service.EmailService;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.MQService.Utils.CommonUtil.MQUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailMQServiceImpl{

    @Resource
    MQUtil mqUtil;

    public void emailSendByQQMail(EmailPO emailPO) throws Exception {
        //考虑插入数据库中
        System.out.println("发送： "+emailPO.getToEmail()+"  邮件，账号为： "+emailPO.getToEmail()+" ，内容为： "+emailPO.getContent());
        mqUtil.SendEmailMQ("EmailMessage",emailPO);
    }

    public void emailSendToAdmin(EmailPO emailPO) throws Exception {

        //考虑插入数据库中
        System.out.println("邮件信息："+emailPO);
        emailPO.setToEmail("2413629661@qq.com");
        mqUtil.SendEmailMQ("EmailMessage",emailPO);
    }
}
