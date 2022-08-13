package com.example.schedule.Utils.feign;

import com.example.MQService.Entity.PO.EmailPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MQService")
public interface EmailMQFeign {
    @PostMapping("/EmailMQFeign/emailSendByQQMail")
    void emailSendByQQMail(@RequestBody EmailPO emailPO) throws Exception;

    @PostMapping("/EmailMQFeign/emailSendToAdmin")
    void emailSendToAdmin(@RequestBody EmailPO emailPO) throws Exception;
}
