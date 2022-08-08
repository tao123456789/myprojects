package com.example.common.Service.Impl;

import com.example.common.Api.RedisService;
import com.example.common.Utils.redis.RedisUtils;
import com.example.common.Entity.PO.RedisPO.RedisPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
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
