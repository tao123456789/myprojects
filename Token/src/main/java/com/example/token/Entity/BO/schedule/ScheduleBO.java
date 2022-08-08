package com.example.token.Entity.BO.schedule;

import lombok.Data;

@Data
public class ScheduleBO {
    private int id;

    private int userid;

    private String TaskContent;

    private String CreateTime;

    private String CreateName;

    private String UpdateTime;

    private String UpdateName;

    @Override
    public String toString() {
        return "ScheduleBo{" +
                "id=" + id +
                ", userid=" + userid +
                ", TaskContent='" + TaskContent + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", CreateName='" + CreateName + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                ", UpdateName='" + UpdateName + '\'' +
                '}';
    }
}
