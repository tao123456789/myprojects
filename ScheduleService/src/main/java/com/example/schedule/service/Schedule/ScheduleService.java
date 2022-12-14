package com.example.schedule.service.Schedule;

import com.example.schedule.Entity.BO.schedule.ScheduleBO;
import com.example.schedule.Entity.BO.schedule.ScheduleTaskBO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScheduleService {

    List<ScheduleBO> getScheduleList(int userid);
    List<ScheduleTaskBO> getScheduleTaskList(int userid, String startTime);
    Boolean addSchedule(ScheduleBO scheduleBO);
    Boolean addScheduleTask(ScheduleTaskBO scheduleTaskBO);
    Boolean updateScheduleTaskStatus(int taskid,String usermail) throws Exception;
    Boolean deleteSchedule(int id);
    Boolean deleteScheduleTask(int id);
}
