package com.example.token.Entity.BO.menu;

import lombok.Data;
import java.util.ArrayList;

@Data
public class menu {
    private Integer userID;
    private Integer groupID;
    private String groupName;
    private ArrayList<action> actionArr;

    @Override
    public String toString() {
        return "menu{" +
                "userID=" + userID +
                ", groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", actionArr=" + actionArr +
                '}';
    }
}
