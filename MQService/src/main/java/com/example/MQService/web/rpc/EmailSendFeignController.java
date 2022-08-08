package com.example.MQService.web.rpc;

import com.example.MQService.Api.EmailMQService;
import com.example.MQService.Entity.PO.EmailPO;
import com.example.MQService.Service.EmailService.EmailMQServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
@Api(tags = "邮件发送的MQ队列服务")
public class EmailSendFeignController implements EmailMQService {
    @Resource
    EmailMQServiceImpl emailService;

    @PostMapping("/emailSendByQQMail")
    @ApiOperation("MQ邮件发送")
    public void emailSendByQQMail (@RequestBody EmailPO emailPO) throws Exception {
        emailService.emailSendByQQMail(emailPO);
    }

    @PostMapping("/emailSendToAdmin")
    @ApiOperation("MQ邮件发送")
    public void emailSendToAdmin (@RequestBody EmailPO emailPO) throws Exception {
        emailService.emailSendToAdmin(emailPO);
    }
}
