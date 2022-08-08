package com.example.common.Entity.BO.User;

import lombok.Data;

@Data
public class UserBO {
    private int id;

    private String userName;

    private String userPasswd;

    private String realName;

    private String qqmail;

    private String tel;

    private String ip;

    private String area;

    private String brower;

    private String os;

    private String logintime;

    private String inviteAuth;

    private String beinviteauth;

    @Override
    public String toString () {
        return "UserBO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", realName='" + realName + '\'' +
                ", qqmail='" + qqmail + '\'' +
                ", tel='" + tel + '\'' +
                ", ip='" + ip + '\'' +
                ", area='" + area + '\'' +
                ", brower='" + brower + '\'' +
                ", os='" + os + '\'' +
                ", logintime='" + logintime + '\'' +
                ", inviteAuth='" + inviteAuth + '\'' +
                ", beinviteauth='" + beinviteauth + '\'' +
                '}';
    }

}
