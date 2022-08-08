package com.example.MQService.Api;

import com.example.MQService.Entity.PO.EmailPO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EmailMQFeign")
public interface EmailMQService {
    @PostMapping("/emailSendByQQMail")
    @ApiOperation("MQ邮件发送")
    void emailSendByQQMail (@RequestBody EmailPO emailPO) throws Exception;

    @PostMapping("/emailSendToAdmin")
    @ApiOperation("MQ邮件发送")
    void emailSendToAdmin (@RequestBody EmailPO emailPO) throws Exception;
}
