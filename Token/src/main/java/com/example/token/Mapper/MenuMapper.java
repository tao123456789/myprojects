package com.example.token.Mapper;

import com.example.token.Entity.BO.menu.action;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    //获取用户权限组
    Integer GetUserGroup(int userid);
    //获取权限组列表
    List<Integer> GetGroupAction(int groupid);
    //获取菜单列表权限
    action GetActionUrl(Integer actionid);
}
