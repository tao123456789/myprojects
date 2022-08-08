package com.example.token.Utils.setting;

import com.example.common.Entity.BO.setting.SettingBO;
import com.example.token.Service.SettingService.SettingServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SettingUtil {
    @Resource
    SettingServiceImpl settingService;

    public String getSettingCodeByName(String name){
        SettingBO settingBO=new SettingBO();
        settingBO.setName(name);
        return settingService.getSetting(settingBO).get(0).getCode();
    }
}
