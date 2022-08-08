package com.example.token.Api.MMS.menu;

import com.alibaba.fastjson.JSONObject;
import com.example.token.Utils.feign.CommonServiceFeign;
import com.example.common.Entity.BO.User.UserBO;
import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.menu.action;
import com.example.token.Service.MMSService.MenuService.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单权限")
public class MenuController {
    @Autowired
    @Qualifier("MenuService1")
    private MenuService menuService;
    @Resource
    private CommonServiceFeign commonServiceFeign;
    @Autowired
    HttpServletRequest httpServletRequest;

    @UserLoginToken
    @GetMapping("/getMenu")
    @ResponseBody
    @ApiOperation("获取用户权限")
    @AspectLogAnnptation
    public String GetUserMenu() {
        String token = httpServletRequest.getHeader("token");
        if(token==null){
            throw new RuntimeException("[token服务]无token，请重新登录");
        }
        int userid=(int) commonServiceFeign.get(token);
        UserBO userBO=commonServiceFeign.GetUserByUserId(userid);
        System.out.println("当前token用户："+userBO.getUserName());

        Integer groupid = menuService.GetUserGroup(userid);
        List<Integer> actionid;//获取用户的菜单权限id
        //用户权限集合
        ArrayList<action> actionArr = new ArrayList<>();
        if (groupid == 0) {
            throw new RuntimeException("用户未加入权限组！");
        } else {
            actionid = menuService.GetGroupAction(groupid);
        }

        System.out.println("用户id:" + userid + ",管理组id：" + groupid + ",权限id:" + actionid);
        for (int i = 0; i < actionid.size(); i++) {
            action action1 = menuService.GetActionUrl(actionid.get(i));
            actionArr.add(action1);
        }

        //组装数据
        ArrayList<JSONObject> jsonObjectsVO = new ArrayList<>();
        for (action item : actionArr) {
            JSONObject jsonObject = new JSONObject();
            if (item.getAction_level().equals("1")) {
                jsonObject.put("icon", item.getAction_icon());
                jsonObject.put("name", item.getAction_name());
                jsonObject.put("url", item.getAction_url());

                //Children目录
                ArrayList<JSONObject> jsonObjects = new ArrayList<>();
                for (action item2 : actionArr) {
                    if (!Objects.equals(item2.getAction_parent_id(), "")) {
                        if (Objects.equals(item2.getAction_parent_id(), item.getAction_id())) {
                            JSONObject jsonObject1 = new JSONObject();
//                            jsonObject1.put("icon", item2.getAction_icon());
                            jsonObject1.put("name", item2.getAction_name());
                            jsonObject1.put("url", item2.getAction_url());
                            jsonObjects.add(jsonObject1);
                        }
                    }
                    jsonObject.put("children", jsonObjects);
                }
            }
            if(!jsonObject.isEmpty()) {
                jsonObjectsVO.add(jsonObject);
            }
        }
        System.out.println("全部的菜单权限为：" + jsonObjectsVO.toString());
        return jsonObjectsVO.toString();
    }
}
