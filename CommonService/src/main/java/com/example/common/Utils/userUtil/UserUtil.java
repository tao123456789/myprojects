package com.example.common.Utils.userUtil;

import com.example.common.Service.Impl.UserServicImpl.UserServiceImpl;
import com.example.common.Utils.redis.RedisUtils;
import com.example.common.Entity.BO.User.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil {
    @Resource
    RedisUtils redisUtils;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Resource
    UserServiceImpl userServiceImpl;

    public UserBO getCurrentUserInfo(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println(httpServletRequest.getHeader("token"));
        String token = httpServletRequest.getHeader("token");

        UserBO userBO=new UserBO();

        if(token==null){
            System.out.println("[common服务]无token，请重新登录");
        }
        try {
            int userid = (int) redisUtils.get(token);
            userBO = userServiceImpl.GetUserByUserId(userid);
            System.out.println("当前token用户：" + userBO.getUserName());
        }catch (Exception e){
            System.out.println("获取当前用户失败");
        }
        System.out.println("---------------------------------------------------------------------");
        return userBO;
    }
}
