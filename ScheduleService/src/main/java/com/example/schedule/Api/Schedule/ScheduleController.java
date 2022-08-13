package com.example.schedule.Api.Schedule;

import com.example.schedule.Entity.BO.schedule.ScheduleBO;
import com.example.schedule.Entity.BO.schedule.ScheduleTaskBO;
import com.example.schedule.Utils.date.DateUtil;
import com.example.schedule.Utils.feign.CommonServiceFeign;
import com.example.schedule.service.Schedule.Impl.ScheduleServiceImpl;
import com.example.schedule.service.Schedule.Impl.ScheduleTask;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/DailySchedule")
public class ScheduleController {

    @Resource
    private ScheduleServiceImpl scheduleServiceImpl;

    @Resource
    ScheduleTask scheduleTask;

    @Autowired
    CommonServiceFeign userUtil;

    @GetMapping("/getScheduleTaskList")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleTaskBO> getScheduleTaskList() {
        return scheduleServiceImpl.getScheduleTaskList(userUtil.getCurrentUserInfo().getId(),new DateUtil().getNowFormat2());
    }

    @GetMapping("/getScheduleList")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleBO> getScheduleList() {
        return scheduleServiceImpl.getScheduleList(userUtil.getCurrentUserInfo().getId());
    }

    @PostMapping("/addSchedule")
    @ApiOperation("添加每日任务")
    public Boolean addSchedule(@RequestBody ScheduleBO scheduleBO) {
        scheduleBO.setUserid(userUtil.getCurrentUserInfo().getId());
        scheduleBO.setUpdateTime(new DateUtil().getNowFormat3());
        scheduleBO.setCreateTime(new DateUtil().getNowFormat3());
        scheduleBO.setCreateName(userUtil.getCurrentUserInfo().getRealName());
        scheduleBO.setUpdateName(userUtil.getCurrentUserInfo().getRealName());
        log.info(String.valueOf(scheduleBO));
        return scheduleServiceImpl.addSchedule(scheduleBO);
    }

    @PostMapping("/addScheduleTask")
    @ApiOperation("添加每日任务列表")
    public Boolean addScheduleTask(@RequestBody ScheduleTaskBO scheduleTaskBO) {
        log.info(String.valueOf(scheduleTaskBO));
        return scheduleServiceImpl.addScheduleTask(scheduleTaskBO);
    }

    @GetMapping("/updateScheduleTaskStatus/{taskid}")
    @ApiOperation("更新任务状态")
    public Boolean updateScheduleTaskStatus(@PathVariable("taskid") int taskid) throws Exception {
        log.info(String.valueOf(taskid));
        String usermail= userUtil.getCurrentUserInfo().getQqmail();
        System.out.println(usermail);
        return scheduleServiceImpl.updateScheduleTaskStatus(taskid,usermail);
    }

    @GetMapping("/createScheduleTask")
    @ApiOperation("生成每日任务")
    public void createScheduleTask() throws Exception {
        scheduleTask.dailyScheduleTask();
    }

    @GetMapping("/deleteScheduleTask")
    @ApiOperation("删除任务")
    public void deleteScheduleTask(int id) throws Exception {
        scheduleServiceImpl.deleteScheduleTask(id);
    }

    @GetMapping("/deleteSchedule")
    @ApiOperation("删除每日任务")
    public void deleteSchedule(int id) throws Exception {
        scheduleServiceImpl.deleteSchedule(id);
    }
}
