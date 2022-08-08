package com.example.token.Service.MMSService.MenuService;

import com.example.token.Entity.BO.menu.action;

import java.util.List;

public interface MenuService {
    Integer GetUserGroup(int userid);
    List<Integer> GetGroupAction(int group);
    action GetActionUrl(Integer actionid);
}
