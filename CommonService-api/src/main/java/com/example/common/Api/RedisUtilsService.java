package com.example.common.Api;

import org.springframework.web.bind.annotation.*;
import com.example.common.Entity.PO.RedisPO.RedisPO;

@RestController
@RequestMapping("/common/redis")
public interface RedisUtilsService {
    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    @GetMapping("/getExpire")
    long getExpire(@RequestParam("key")String key);

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    @GetMapping("/hasKey")
    boolean hasKey(@RequestParam("key") String key);

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    @GetMapping("/getRedis")
    Object get(@RequestParam("key")String key);


    /**
     * 普通缓存放入并设置时间
     * @return true成功 false 失败
     */
    @PostMapping("/setRedis")
    boolean set(@RequestBody RedisPO redisPO);
}
