package com.example.token.Service.MMSService.MenuService.Impl;

import com.example.token.Entity.BO.menu.action;
import com.example.token.Mapper.MenuMapper;
import com.example.token.Service.MMSService.MenuService.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MenuService1")
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public Integer GetUserGroup(int userid){
        return menuMapper.GetUserGroup(userid);
    };

    @Override
    public List<Integer> GetGroupAction(int groupid){
        return menuMapper.GetGroupAction(groupid);
    }

    @Override
    public action GetActionUrl(Integer actionid){
        return menuMapper.GetActionUrl(actionid);
    };

}
