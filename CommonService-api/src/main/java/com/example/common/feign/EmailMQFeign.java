package com.example.common.feign;

import com.example.MQService.Entity.PO.EmailPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "MQService")
public interface EmailMQFeign {

    @PostMapping("/EmailMQFeign/emailSendByQQMail")
    void emailSendByQQMail(EmailPO emailPO) throws Exception;

    @PostMapping("/EmailMQFeign/emailSendToAdmin")
    void emailSendToAdmin(EmailPO emailPO) throws Exception;
}
