package com.example.token.Service.Schedule.Impl;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;
import com.example.token.Mapper.ScheduleMapper;
import com.example.token.Service.EmailService.EmailServiceImpl;
import com.example.token.Utils.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleTask {
    @Resource
    ScheduleMapper scheduleMapper;
    @Resource
    EmailServiceImpl emailServiceImpl;


    public void dailyScheduleTask() throws Exception {
        List<ScheduleBO> scheduleBOList = scheduleMapper.getAllScheduleList();
        List<String> taskList=new ArrayList<>();
        for (ScheduleBO scheduleBO : scheduleBOList) {
            //类型转换
            ScheduleTaskBO scheduleTaskBO = new ScheduleTaskBO();
            scheduleTaskBO.setStatus("0");
            scheduleTaskBO.setCreateName(scheduleBO.getCreateName());
            scheduleTaskBO.setCreateTime(new DateUtil().getNowFormat2());
            scheduleTaskBO.setTaskContent(scheduleBO.getTaskContent());
            scheduleTaskBO.setUserid(scheduleBO.getUserid());
            scheduleTaskBO.setExcuteTime(new DateUtil().getNowFormat2());
            scheduleTaskBO.setUpdateName(scheduleBO.getUpdateName());
            scheduleTaskBO.setUpdateTime(new DateUtil().getNowFormat2());
            taskList.add(scheduleBO.getTaskContent());
            if (scheduleMapper.addScheduleTask(scheduleTaskBO)) {
                System.out.println("添加成功！");
            }
        }
        EmailPO emailPO=new EmailPO();
        emailPO.setTitle("【每日任务更新】");
        emailPO.setSubject("【每日任务更新】");
        emailPO.setContent(taskList.toString());
        emailServiceImpl.emailSendToAdmin(emailPO);
    }
}
