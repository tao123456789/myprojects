package com.example.token.Api.Logger;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.aspectlog.AspectLogBO;
import com.example.common.Entity.BO.subscriber.SubscriberBO;
import com.example.token.Entity.VO.page.PageVo;
import com.example.token.Service.AspectLogService.AspectLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/logger")
@Api(tags = "日志信息")
public class LoggerApi {
    @Resource
    AspectLogServiceImpl aspectLogServiceImpl;

    @UserLoginToken
    @GetMapping("/getLog")
    @ResponseBody
    @ApiOperation("获取日志信息")
    public String getLog() throws IOException {
        File file=new File("/jar/Token/Token.log");
        ArrayList<String> log=new ArrayList<>();
        if(!file.exists()){
            System.out.println("日志文件不存在");
            return "日志文件不存在";
        }
        FileInputStream fis=new FileInputStream("/jar/Token/Token.log");
        InputStreamReader is=new InputStreamReader(fis,"UTF-8");
        BufferedReader br=new BufferedReader(is);
        String line="";
        while ((line = br.readLine())!=null){
            log.add(line);
        }
        System.out.println("获取日志文件成功，日志大小为："+log.size());
        return log.toString();
    }

    @UserLoginToken
    @GetMapping("/getAspectLog")
    @ResponseBody
    @ApiOperation("获取切面日志信息")
    public List<AspectLogBO> getAspectLogList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        return aspectLogServiceImpl.getAspectLogList(page,size);
    }

    @UserLoginToken
    @PostMapping("/getAspectLogPage")
    @ResponseBody
    @ApiOperation("获取切面日志信息")
    @AspectLogAnnptation
    public int getAspectLogPage(@RequestBody PageVo pageVo){
        return aspectLogServiceImpl.getAspectLogPage(pageVo);
    }

    @UserLoginToken
    @GetMapping("/getAspectLogInfoByUuid")
    @ResponseBody
    @ApiOperation("获取切面日志详细信息")
    @AspectLogAnnptation
    public AspectLogBO getAspectLogInfoByUuid(String uuid){
        return aspectLogServiceImpl.getAspectLogInfoByUuid(uuid);
    }

    @UserLoginToken
    @GetMapping("/getSubscriberList")
    @ResponseBody
    @ApiOperation("获取订阅者信息")
    @AspectLogAnnptation
    public List<SubscriberBO> getSubscriberList(){
        return aspectLogServiceImpl.getSubscriberList();
    }

    @UserLoginToken
    @GetMapping("/changeStatus")
    @ResponseBody
    @ApiOperation("修改订阅者信息")
    @AspectLogAnnptation
    public Boolean changeStatus(int id,int status){
        return aspectLogServiceImpl.changeStatus(id,status);
    }
}
