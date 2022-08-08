package com.example.token.Mapper;

import com.example.token.Entity.BO.aspectlog.AspectLogBO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AspectLogMapper {
    Boolean insertAspectLog(AspectLogBO aspectLogBO);
    List<AspectLogBO> getAspectLogList(@Param("start") int start,@Param("end") int end);
    int getAspectLogCount();
    AspectLogBO getAspectLogInfoByUuid(String uuid);
}
