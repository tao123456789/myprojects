package com.example.MQService.Entity.PO;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailPO implements Serializable {
    String title;
    String content;
    String subject;
    String toEmail;
}
