package com.example.token.Utils.LogAspect;

import com.example.token.Utils.feign.CommonServiceFeign;
import com.example.token.Entity.BO.aspectlog.AspectLogBO;
import com.example.token.Mapper.AspectLogMapper;
import com.example.token.Utils.date.DateUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Aspect
@Component
@Slf4j
public class WebLogAspect {
    /**
     * 进入方法时间戳
     */
    private Long startTime;
    /**
     * 方法结束时间戳(计时)
     */
    private Long endTime;
    /**
     * 耗时
     */
    private long time;

    @Resource
    AspectLogMapper aspectLogMapper;
    @Resource
    CommonServiceFeign userUtil;
    DateUtil dateUtil = new DateUtil();

    AspectLogBO aspectLogBO=new AspectLogBO();
    String username;

    public WebLogAspect() {
    }


    /**
     * 定义请求日志切入点，其切入点表达式有多种匹配方式,这里是指定路径
     */
    @Pointcut("@annotation(com.example.token.Annotation.AspectLogAnnptation)")
    public void webLogPointcut() {
    }

    /**
     * 前置通知：
     * 1. 在执行目标方法之前执行，比如请求接口之前的登录验证;
     * 2. 在前置通知中设置请求日志信息，如开始时间，请求参数，注解内容等
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLogPointcut()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取请求头中的User-Agent
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        aspectLogBO.setUuid("TASK"+UUID.randomUUID().toString().replaceAll("-", ""));
        aspectLogBO.setCreate_time(dateUtil.getNowFormat3().toString());
        aspectLogBO.setRequest_url(request.getRequestURL().toString());
        aspectLogBO.setRequest_method(request.getMethod());
        aspectLogBO.setRequest_ip(request.getRemoteAddr());
        aspectLogBO.setRequest_data(Arrays.toString(joinPoint.getArgs()));
//        try{
//            username=userUtil.getCurrentUserInfo().getRealName();
//        }catch (Exception e){
//            username="admin";
//            log.info("获取当前用户失败");
//        }
        aspectLogBO.setCreate_name(username);

        //打印请求的内容
        startTime = System.currentTimeMillis();
        log.info("--------------------------------------------切面日志doBefore打印开始------------------------------------------------------");
        log.info("请求开始时间：{}", LocalDateTime.now());
        log.info("请求Url : {}", request.getRequestURL().toString());
        log.info("请求方式 : {}", request.getMethod());
        log.info("请求ip : {}", request.getRemoteAddr());
//        log.info("请求方法 : ", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数 : {}", Arrays.toString(joinPoint.getArgs()));
//        // 系统信息
//        log.info("浏览器：{}", userAgent.getBrowser().toString());
//        log.info("浏览器版本：{}", userAgent.getBrowserVersion());
//        log.info("操作系统: {}", userAgent.getOperatingSystem().toString());

        log.info("--------------------------------------------切面日志doBefore打印结束------------------------------------------------------");
    }

    /**
     * 返回通知：
     * 1. 在目标方法正常结束之后执行
     * 1. 在返回通知中补充请求日志信息，如返回时间，方法耗时，返回值，并且保存日志信息
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLogPointcut()")
    public void doAfterReturning(Object ret) throws Throwable {
        endTime = System.currentTimeMillis();
        aspectLogBO.setStatus("success");
        aspectLogBO.setFinish_time(dateUtil.getNowFormat3().toString());
        String Response_data=ret.toString();
        aspectLogBO.setResponse_data("");
        if(Response_data.length()<1200){
            aspectLogBO.setResponse_data(Response_data);
        }
        else{
            aspectLogBO.setResponse_data(Response_data.substring(1,Response_data.length()/2));
        }
        aspectLogBO.setTime(String.valueOf((endTime - startTime)));
        try{
            username=userUtil.getCurrentUserInfo().getRealName();
        }catch (Exception e){
            username="admin";
            log.info("获取当前用户失败");
        }
        log.info("--------------------------------------------切面日志doAfterReturning打印开始------------------------------------------------------");
        log.info("请求结束时间：{}", LocalDateTime.now());
        log.info("请求耗时：{}", (endTime - startTime));
        // 处理完请求，返回内容
        log.info("请求返回 : {}", ret);
        log.info("插入日志表："+aspectLogBO.toString());
        try {
            aspectLogMapper.insertAspectLog(aspectLogBO);
        }catch (Exception e){
            System.out.println("切面日志插入失败："+e);
            aspectLogBO.setStatus("fail");
            aspectLogBO.setResponse_data(e.toString());
            aspectLogMapper.insertAspectLog(aspectLogBO);
        }
        log.info("--------------------------------------------切面日志doAfterReturning打印结束------------------------------------------------------");
    }

    /**
     * 异常通知：
     * 1. 在目标方法非正常结束，发生异常或者抛出异常时执行
     * 1. 在异常通知中设置异常信息，并将其保存
     *
     * @param throwable
     */
    @AfterThrowing(value = "webLogPointcut()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        aspectLogBO.setStatus("fail");
        aspectLogBO.setFinish_time(dateUtil.getNowFormat3().toString());
        aspectLogBO.setResponse_data(throwable.getMessage());
        // 保存异常日志记录
        log.info("--------------------------------------------切面日志doAfterThrowing打印开始------------------------------------------------------");
        log.error("发生异常时间：{}", LocalDateTime.now());
        log.error("抛出异常：{}", throwable.getMessage());
        aspectLogMapper.insertAspectLog(aspectLogBO);
        log.info("--------------------------------------------切面日志doAfterThrowing打印结束------------------------------------------------------");
    }
}
