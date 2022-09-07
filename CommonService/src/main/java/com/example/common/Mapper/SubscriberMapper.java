package com.example.common.Mapper;

import com.example.common.Entity.BO.SubscriberBO.SubscriberBO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubscriberMapper {
    List<SubscriberBO> getSubscriberByType(String type);
    List<SubscriberBO> getSubscriberList();
    Boolean changeStatus(@Param("id")int id, @Param("status") int status);
}
