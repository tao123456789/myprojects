package com.example.token.Entity.BO.schedule;

import lombok.Data;

@Data
public class ScheduleTaskBO {
    private int id;

    private int userid;

    private String TaskContent;

    private String Status;

    private String ExcuteTime;

    private String CreateTime;

    private String CreateName;

    private String UpdateTime;

    private String UpdateName;

    @Override
    public String toString() {
        return "ScheduleTaskBO{" +
                "id=" + id +
                ", userid=" + userid +
                ", TaskContent='" + TaskContent + '\'' +
                ", Status='" + Status + '\'' +
                ", ScheduleTime='" + ExcuteTime + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", CreateName='" + CreateName + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                ", UpdateName='" + UpdateName + '\'' +
                '}';
    }
}
