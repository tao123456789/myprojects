package com.example.common.Service.Impl.RedisServiceImpl;

import com.example.common.Api.RedisUtilsService;
import com.example.common.Utils.redis.RedisUtils;
import com.example.common.Entity.PO.RedisPO.RedisPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisUtilsServiceImpl implements RedisUtilsService {

    @Resource
    RedisUtils redisUtils;

    @Override
    public long getExpire (String key) {
        return redisUtils.getExpire(key);
    }

    @Override
    public boolean hasKey (String key) {
        return redisUtils.hasKey(key);
    }

    @Override
    public Object get (String key) {
        return redisUtils.get(key);
    }

    @Override
    public boolean set (RedisPO redisPO) {
        return redisUtils.set(redisPO);
    }
}
