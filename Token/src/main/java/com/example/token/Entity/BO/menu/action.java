package com.example.token.Entity.BO.menu;

import lombok.Data;

@Data
public class action {
    int id;
    private String action_id;
    private String action_icon;
    private String action_level;
    private String action_name;
    private String action_url;
    private String action_parent_id;

    @Override
    public String toString() {
        return "action{" +
                "id=" + id +
                ", action_id='" + action_id + '\'' +
                ", action_icon='" + action_icon + '\'' +
                ", action_level='" + action_level + '\'' +
                ", action_name='" + action_name + '\'' +
                ", action_url='" + action_url + '\'' +
                ", action_parent_id='" + action_parent_id + '\'' +
                '}';
    }
}
