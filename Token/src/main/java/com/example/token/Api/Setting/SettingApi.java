package com.example.token.Api.Setting;

import com.example.common.Entity.BO.SettingBO.SettingBO;
import com.example.token.Service.SettingService.SettingServiceImpl;
import com.example.token.Utils.feign.CommonServiceFeign;
import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@UserLoginToken
@Slf4j
@RestController
@RequestMapping("/setting")
public class SettingApi {
    @Autowired
    SettingServiceImpl settingServiceImpl;

    @Resource
    private CommonServiceFeign userServiceImpl;

    @UserLoginToken
    @PostMapping("/getSettingList")
    @ApiOperation("获取设置列表")
    @AspectLogAnnptation
    public List<SettingBO> getSetting(@RequestBody SettingBO settingBO){
        return settingServiceImpl.getSetting(settingBO);
    }

    @UserLoginToken
    @PostMapping("/updateSettingByName")
    @ApiOperation("修改设置列表")
    @AspectLogAnnptation
    public Boolean updateSettingByName(@RequestBody SettingBO settingBO){
        return settingServiceImpl.updateSettingByName(settingBO);
    }
}
