package com.example.token.Api.User;

import com.example.token.Utils.feign.CommonServiceFeign;
import com.example.common.Entity.BO.Module.ModuleBO;
import com.example.common.Entity.BO.User.UserBO;
import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.common.Entity.VO.UserModuleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@UserLoginToken
@RestController
@CrossOrigin
@Api(tags = "获取用户信息")
@RequestMapping("/user")
public class UserController {
    @Resource
    private CommonServiceFeign userService;


    @GetMapping("/getAllUser")
    @AspectLogAnnptation
    public List<UserBO> GetAllUser(){
        UserBO userBO=new UserBO();
        List<UserBO> userBOList = userService.GetAllUser(userBO);
        if (userBOList.isEmpty()) {
            System.out.println("查无此人！！！");
        }
        return userBOList;
    }

    @GetMapping("/getUserByUserId")
    @AspectLogAnnptation
    public UserBO GetUserByUserId(){
        return userService.GetUserByUserId(userService.getCurrentUserInfo().getId());
    }

    @GetMapping("/getUserByUserName/{username}")
    @AspectLogAnnptation
    public UserBO GetUserByUesrName(@PathVariable String username){
//        System.out.println("将要获取的username:"+id);
//        System.out.println("获取到的username:"+userService.GetUserByName(id));
        return userService.GetUserByUserName(username);
    }

    @PostMapping("/updateUserInfo")
    @AspectLogAnnptation
    public Boolean updateUserInfo(@RequestBody UserBO userBO){
        if(userBO.getUserPasswd()==""){
            userBO.setUserPasswd(null);
        }
        userBO.setId(userService.getCurrentUserInfo().getId());
        int i=userService.updateUserInfo(userBO);
        System.out.println("更新？："+i);
        return (i==1);
    }

    @GetMapping("/GetModule")
    @AspectLogAnnptation
    public List<UserModuleVO> GetModule(){
        int userid=userService.getCurrentUserInfo().getId();
        //获取用户模块权限
        List<UserModuleVO> userModuleVOList=userService.getUserModuleByUserId(userid);
        System.out.println("用户获取模块权限："+userModuleVOList.toString());
        return userModuleVOList;
    }

    @GetMapping("/GetAllModuleList")
    @AspectLogAnnptation
    @ApiOperation("获取模块列表")
    public List<ModuleBO> GetAllModuleList(){
        List<ModuleBO> AllModuleList=userService.getAllModuleList();
        System.out.println("模块列表："+AllModuleList.toString());
        return AllModuleList;
    }

    @GetMapping("/GetModuleByUserId")
    @AspectLogAnnptation
    public List<UserModuleVO> GetModuleByUserId(int userid){
        //获取用户模块权限
        List<UserModuleVO> userModuleVOList=userService.getUserModuleByUserId(userid);
        System.out.println("用户获取模块权限："+userModuleVOList.toString());
        return userModuleVOList;
    }

    @GetMapping("/removeModule")
    @AspectLogAnnptation
    @ApiOperation("移除首页模块权限")
    public Boolean removeModule(int id){
        return userService.removeModuleByID(id);
    }

    @GetMapping("/insertUserModule")
    @AspectLogAnnptation
    @ApiOperation("添加模块权限")
    public Boolean insetUserModule(UserModuleVO userModuleVO){
        return userService.insertUserModule(userModuleVO);
    }
}
