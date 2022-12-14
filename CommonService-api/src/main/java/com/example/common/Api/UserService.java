package com.example.common.Api;

import com.example.common.Entity.BO.Module.ModuleBO;
import com.example.common.Entity.BO.User.UserBO;
import com.example.common.Entity.VO.UserModuleVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common/user")
public interface UserService {
    @PostMapping("/getAllUser")
    List<UserBO> GetAllUser(@RequestBody UserBO userBO);

    @GetMapping("/getUserByUserId")
    UserBO GetUserByUserId(@RequestParam("userid")int userid);

    @GetMapping("/getUserByUserName")
    UserBO GetUserByUserName(@RequestParam("username") String username);

    @PostMapping("/insertUser")
    int insertUser(@RequestBody UserBO user);

    int deleteUser(int userid);

    @PostMapping("/updateUser")
    int updateUser(@RequestBody UserBO user);

    @PostMapping("/updateUserInfo")
    int updateUserInfo(@RequestBody UserBO user);

    @PostMapping("/getUserModuleByUserId")
    List<UserModuleVO> getUserModuleByUserId(@RequestParam("userid")int userid);

    @PostMapping("/removeModuleByID")
    Boolean removeModuleByID(@RequestParam("id")int id);

    @PostMapping("/getAllModuleList")
    List<ModuleBO> getAllModuleList();

    @PostMapping("/insertUserModule")
    Boolean insertUserModule(@RequestBody UserModuleVO userModuleVO);

    @GetMapping("/getCurrentUserInfo")
    UserBO getCurrentUserInfo();
}
