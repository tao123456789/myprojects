package com.example.common.Service.Impl.UserServicImpl;

import com.example.common.Utils.userUtil.UserUtil;
import com.example.common.Entity.VO.UserModuleVO;
import com.example.common.Mapper.ModuleMapper;
import com.example.common.Mapper.UserMapper;
import com.example.common.Entity.BO.Module.ModuleBO;
import com.example.common.Entity.BO.User.UserBO;
import com.example.common.Api.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    ModuleMapper moduleMapper;
    @Resource
    UserUtil userUtil;

    @Override
    public List<UserBO> GetAllUser(UserBO userBO){
        return userMapper.GetAllUser(userBO);
    }

    @Override
    public UserBO GetUserByUserId(int userid){
        return userMapper.GetUserByUserId(userid);
    }

    @Override
    public UserBO GetUserByUserName(String username) {
        System.out.println("获取用户信息："+userMapper.GetUserByUserName(username).toString());
        return userMapper.GetUserByUserName(username);
    }

    @Override
    public int deleteUser(int nameid){
        return userMapper.deleteUser(nameid);
    }

    @Override
    public int updateUser(UserBO user){
        System.out.println(user.toString());
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserInfo(UserBO user){
        return userMapper.updateUserInfo(user);
    }

    @Override
    public int insertUser(UserBO user){
        return userMapper.insertUser(user);
    }

    @Override
    public List<UserModuleVO> getUserModuleByUserId(int userid) {
        return moduleMapper.getUserModuleByUserId(userid);
    }

    @Override
    public Boolean removeModuleByID (int id) {
        return moduleMapper.removeModuleByID(id);
    }

    @Override
    public List<ModuleBO> getAllModuleList () {
        return moduleMapper.getAllModuleList();
    }

    @Override
    public Boolean insertUserModule (UserModuleVO userModuleVO) {
        return moduleMapper.insertUserModule(userModuleVO.getUserid(),userModuleVO.getModuleid());
    }

    @Override
    public UserBO getCurrentUserInfo () {
        return userUtil.getCurrentUserInfo();
    }
}
