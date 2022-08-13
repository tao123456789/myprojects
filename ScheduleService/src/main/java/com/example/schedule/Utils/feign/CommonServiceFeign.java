package com.example.schedule.Utils.feign;

import com.example.common.Entity.BO.Module.ModuleBO;
import com.example.common.Entity.BO.User.UserBO;
import com.example.common.Entity.PO.RedisPO.RedisPO;
import com.example.common.Entity.VO.UserModuleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CommonService")
public interface CommonServiceFeign {
    @GetMapping("/common/user/getAllUser")
    List<UserBO> GetAllUser(UserBO userBO);

    @GetMapping("/common/user/getUserByUserId")
    UserBO GetUserByUserId(@RequestParam("userid")int userid);

    @GetMapping("/common/user/getUserByUserName")
    UserBO GetUserByUserName(@RequestParam("username")String username);

    @PostMapping("/common/user/insertUser")
    int insertUser(@RequestBody UserBO user);

    //    int deleteUser(int userid);
    @PostMapping("/common/user/updateUser")
    int updateUser(@RequestBody UserBO user);

    @GetMapping("/common/user/updateUserInfo")
    int updateUserInfo(@RequestBody UserBO user);

    @PostMapping("/common/user/getUserModuleByUserId")
    List<UserModuleVO> getUserModuleByUserId(@RequestParam("userid")int userid);

    @PostMapping("/common/user/removeModuleByID")
    Boolean removeModuleByID(@RequestParam("id")int id);

    @PostMapping("/common/user/getAllModuleList")
    List<ModuleBO> getAllModuleList();

    @PostMapping("/common/user/insertUserModule")
    Boolean insertUserModule(@RequestBody UserModuleVO userModuleVO);

    @GetMapping("/common/user/getCurrentUserInfo")
    UserBO getCurrentUserInfo();


    /**
     * 普通缓存放入并设置时间
     * @return true成功 false 失败
     */
    @PostMapping("/common/redis/setRedis")
    boolean set(@RequestBody RedisPO redisPO);

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    @GetMapping("/common/redis/getExpire")
    long getExpire(@RequestParam("key")String key);

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    @GetMapping("/common/redis/hasKey")
    boolean hasKey(@RequestParam("key")String key);

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    @GetMapping("/common/redis/getRedis")
    Object get(@RequestParam("key")String key);
}

