package com.example.token.Api.Schedule;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;
import com.example.token.Service.Schedule.Impl.ScheduleServiceImpl;
import com.example.token.Service.Schedule.Impl.ScheduleTask;
import com.example.token.Utils.date.DateUtil;
import com.example.token.Utils.feign.CommonServiceFeign;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@UserLoginToken
@Slf4j
@RestController
@RequestMapping("/DailySchedule")
public class ScheduleController {

    @Resource
    ScheduleServiceImpl scheduleServiceImpl;

    @Resource
    ScheduleTask scheduleTask;

    @Autowired
    private CommonServiceFeign userUtil;

    @UserLoginToken
    @GetMapping("/getScheduleTaskList")
    @ApiOperation("获取每日任务列表")
    @AspectLogAnnptation
    public List<ScheduleTaskBO> getScheduleTaskList() {
        return scheduleServiceImpl.getScheduleTaskList(userUtil.getCurrentUserInfo().getId(),new DateUtil().getNowFormat2());
    }

    @UserLoginToken
    @GetMapping("/getScheduleList")
    @ApiOperation("获取每日任务列表")
    @AspectLogAnnptation
    public List<ScheduleBO> getScheduleList() {
        return scheduleServiceImpl.getScheduleList(userUtil.getCurrentUserInfo().getId());
    }

    @UserLoginToken
    @PostMapping("/addSchedule")
    @ApiOperation("添加每日任务")
    @AspectLogAnnptation
    public Boolean addSchedule(@RequestBody ScheduleBO scheduleBO) {
        scheduleBO.setUserid(userUtil.getCurrentUserInfo().getId());
        scheduleBO.setUpdateTime(new DateUtil().getNowFormat3());
        scheduleBO.setCreateTime(new DateUtil().getNowFormat3());
        scheduleBO.setCreateName(userUtil.getCurrentUserInfo().getRealName());
        scheduleBO.setUpdateName(userUtil.getCurrentUserInfo().getRealName());
        log.info(String.valueOf(scheduleBO));
        return scheduleServiceImpl.addSchedule(scheduleBO);
    }

    @UserLoginToken
    @PostMapping("/addScheduleTask")
    @ApiOperation("添加每日任务列表")
    @AspectLogAnnptation
    public Boolean addScheduleTask(@RequestBody ScheduleTaskBO scheduleTaskBO) {
        log.info(String.valueOf(scheduleTaskBO));
        return scheduleServiceImpl.addScheduleTask(scheduleTaskBO);
    }

    @UserLoginToken
    @GetMapping("/updateScheduleTaskStatus/{taskid}")
    @ApiOperation("更新任务状态")
    @AspectLogAnnptation
    public Boolean updateScheduleTaskStatus(@PathVariable("taskid") int taskid) throws Exception {
        log.info(String.valueOf(taskid));
        String usermail= userUtil.getCurrentUserInfo().getQqmail();
        System.out.println(usermail);
        return scheduleServiceImpl.updateScheduleTaskStatus(taskid,usermail);
    }

    @UserLoginToken
    @GetMapping("/createScheduleTask")
    @ApiOperation("生成每日任务")
    @AspectLogAnnptation
    public void createScheduleTask() throws Exception {
        scheduleTask.dailyScheduleTask();
    }

    @UserLoginToken
    @GetMapping("/deleteScheduleTask")
    @ApiOperation("删除任务")
    @AspectLogAnnptation
    public void deleteScheduleTask(int id) throws Exception {
        scheduleServiceImpl.deleteScheduleTask(id);
    }

    @UserLoginToken
    @GetMapping("/deleteSchedule")
    @ApiOperation("删除每日任务")
    @AspectLogAnnptation
    public void deleteSchedule(int id) throws Exception {
        scheduleServiceImpl.deleteSchedule(id);
    }
}
