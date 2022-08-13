package com.example.schedule.service.Schedule.Impl;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.schedule.Entity.BO.schedule.ScheduleBO;
import com.example.schedule.Entity.BO.schedule.ScheduleTaskBO;
import com.example.schedule.Mapper.ScheduleMapper;
import com.example.schedule.Utils.date.DateUtil;
import com.example.schedule.Utils.feign.EmailMQFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleTask {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    EmailMQFeign emailServiceImpl;


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
        emailPO.setContent(taskList.toString());
        emailPO.setTitle("添加任务更新");
        emailPO.setSubject("添加任务更新");
        emailServiceImpl.emailSendToAdmin(emailPO);
    }
}
