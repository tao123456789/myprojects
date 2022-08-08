package com.example.common.Mapper;

import com.example.common.Entity.BO.setting.SettingBO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SettingMapper {
    List<SettingBO> getSetting(SettingBO settingBO);
    Boolean updateSettingByName(SettingBO settingBO);
}
