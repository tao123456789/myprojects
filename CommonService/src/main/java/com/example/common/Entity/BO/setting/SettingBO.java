package com.example.common.Entity.BO.setting;

import lombok.Data;

@Data
public class SettingBO {
    int id;
    int type;
    String name;
    String code;
    String remark;

    @Override
    public String toString () {
        return "SettingBO{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
