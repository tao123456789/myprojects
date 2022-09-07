package com.example.token.Service.SettingService;

import com.example.common.Entity.BO.SettingBO.SettingBO;
import com.example.token.Utils.feign.SettingServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SettingServiceImpl {
    @Autowired
    SettingServiceFeign settingServiceFeign;

    public List<SettingBO> getSetting(SettingBO settingBO){
        System.out.println(settingBO);
        return settingServiceFeign.getSetting(settingBO);
    }
    public Boolean updateSettingByName(SettingBO settingBO){
        return settingServiceFeign.updateSettingByName(settingBO);
    }
}
