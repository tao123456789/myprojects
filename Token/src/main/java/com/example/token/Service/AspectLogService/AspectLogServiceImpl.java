package com.example.token.Service.AspectLogService;

import com.example.token.Entity.BO.aspectlog.AspectLogBO;
import com.example.token.Mapper.AspectLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AspectLogServiceImpl {

    @Resource
    AspectLogMapper aspectLogMapper;
//    @Resource
//    SubscriberMapper subscriberMapper;

    public List<AspectLogBO> getAspectLogList(int page, int size){
        int start=size*(page-1);
        int end=size*page;
        System.out.println("start:"+start+",end:"+end);
        return aspectLogMapper.getAspectLogList(start,end);
    }

    public int getAspectLogPage(){
        return aspectLogMapper.getAspectLogCount();
    }

    public AspectLogBO getAspectLogInfoByUuid(String uuid){
        return aspectLogMapper.getAspectLogInfoByUuid(uuid);
    }

//    public List<SubscriberBO> getSubscriberList(){
//        return subscriberMapper.getSubscriberList();
//    }

    public Boolean changeStatus(int id,int status){
//        return subscriberMapper.changeStatus(id,status);
        return false;
    }
}
