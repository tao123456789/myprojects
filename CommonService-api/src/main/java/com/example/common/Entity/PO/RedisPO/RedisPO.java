package com.example.common.Entity.PO.RedisPO;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class RedisPO {
    /**
     *          *
     *          * @param key      键
     *          * @param value    值
     *          * @param time     时间 time要大于0 如果time小于等于0 将设置无限期
     *          * @param timeUnit 时间单位
     */
    String key;
    Object value;
    long time;
    TimeUnit timeUnit;
}
