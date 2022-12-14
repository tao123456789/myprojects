package com.example.schedule.Mapper;

import com.example.schedule.Entity.BO.schedule.ScheduleBO;
import com.example.schedule.Entity.BO.schedule.ScheduleTaskBO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    List<ScheduleBO> getScheduleList(@Param("userid") int userid);
    List<ScheduleBO> getAllScheduleList();
    List<ScheduleTaskBO> getScheduleTaskList(@Param("userid") int userid, @Param("startTime") String startTime);
    ScheduleTaskBO getScheduleTaskListById(@Param("id") int id);
    Boolean addSchedule(ScheduleBO scheduleBo);
    Boolean addScheduleTask(ScheduleTaskBO scheduleTaskBO);
    Boolean updateScheduleTaskStatus(int taskid);
    Boolean deleteSchedule(int id);
    Boolean deleteScheduleTask(int id);
}
