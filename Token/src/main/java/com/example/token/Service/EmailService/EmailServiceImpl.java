package com.example.token.Service.EmailService;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.token.Utils.feign.EmailMQFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmailServiceImpl {
    @Autowired
    private EmailMQFeign emailMQFeign;

    public void emailSendByQQMail(@RequestBody EmailPO emailPO) throws Exception{
        System.out.println("尝试发送邮件："+emailPO);
        emailMQFeign.emailSendByQQMail(emailPO);
    };

    public void emailSendToAdmin(@RequestBody EmailPO emailPO) throws Exception{
        System.out.println("发送邮件给admin："+emailPO);
        emailMQFeign.emailSendToAdmin(emailPO);
    };
}
