package com.example.token.Entity.BO.aspectlog;

import com.example.token.Utils.BasicClass.BasicClass;
import lombok.Data;

@Data
public class AspectLogBO{
    int id;
    String uuid;
    String status;
    String request_url;
    String request_method;
    String request_ip;
    String request_data;
    String response_data;
    String create_name;
    String create_time;
    String finish_time;
    String time;

    @Override
    public String toString() {
        return "AspectLogBO{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", status='" + status + '\'' +
                ", request_url='" + request_url + '\'' +
                ", request_method='" + request_method + '\'' +
                ", request_ip='" + request_ip + '\'' +
                ", request_data='" + request_data + '\'' +
                ", response_data='" + response_data + '\'' +
                ", create_name='" + create_name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", finish_time='" + finish_time + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
