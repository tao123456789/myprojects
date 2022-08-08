package com.example.token.Entity.BO.netdisk;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "fileinfo")
public class FileInfoBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String f_id;
    String f_namesvr;
    String f_pid;
    String f_pidroot;
    int f_fdtask;
    int f_lenloc;
    String f_md5;
    String f_pathloc;
    int f_userid;
    String f_create_time;

    @Override
    public String toString () {
        return "FileInfoBO{" +
                "id=" + id +
                ", f_id='" + f_id + '\'' +
                ", f_namesvr='" + f_namesvr + '\'' +
                ", f_pid='" + f_pid + '\'' +
                ", f_pidroot='" + f_pidroot + '\'' +
                ", f_fdtask=" + f_fdtask +
                ", f_lenloc=" + f_lenloc +
                ", f_md5='" + f_md5 + '\'' +
                ", f_pathloc='" + f_pathloc + '\'' +
                ", f_userid=" + f_userid +
                ", f_create_time='" + f_create_time + '\'' +
                '}';
    }
}
