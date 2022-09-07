package com.example.schedule.service;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.schedule.Utils.feign.EmailMQFeign;
import com.example.schedule.service.NotApiService.NotApiServiceImpl;
import com.example.schedule.service.Schedule.Impl.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class common {
    /*
    1，定时任务的cron的格式
    （1）秒 分 时 日 月 星期 年
    （2）秒 分 时 日 月 星期
        1.秒（0~59）
        2.分钟（0~59）
        3.小时（0~23）
        4.天（月）（0~31，但是你需要考虑你月的天数）
        5.月（0~11）
        6.天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
        7.年份（1970－2099）
    2，格式的表达式
        （1）：表示匹配该域的任意值。假如在Minutes域使用, 即表示每分钟都会触发事件。
        （2）?：只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。因为DayofMonth和DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用，如果使用表示不管星期几都会触发，实际上并不是这样
        （3）-：表示范围。例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
        （4）,：表示列出枚举值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。
        （5）#:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三
        （6）/：表示起始时间开始触发，然后每隔固定时间触发一次。例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次
    3，常用示例:
        0 0 12 * * ? 每天12点触发
        0 15 10 ? * * 每天10点15分触发
        0 15 10 * * ? 每天10点15分触发
        0 15 10 * * ? * 每天10点15分触发
        0 15 10 * * ? 2005 2005年每天10点15分触发
        0 * 14 * * ? 每天下午的 2点到2点59分每分触发
        0 0/5 14 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发)
        0 0/5 14,18 * * ? 每天下午的 2点到2点59分、18点到18点59分(整点开始，每隔5分触发)
        0 0-5 14 * * ? 每天下午的 2点到2点05分每分触发
        0 10,44 14 ? 3 WED 3月分每周三下午的 2点10分和2点44分触发
        0 15 10 ? * MON-FRI 从周一到周五每天上午的10点15分触发
        0 15 10 15 * ? 每月15号上午10点15分触发
        0 15 10 L * ? 每月最后一天的10点15分触发
        0 15 10 ? * 6L 每月最后一周的星期五的10点15分触发
        0 15 10 ? * 6L 2002-2005 从2002年到2005年每月最后一周的星期五的10点15分触发
        0 15 10 ? * 6#3 每月的第三周的星期五开始触发
        0 0 12 1/5 * ? 每月的第一个中午开始每隔5天触发一次
        0 11 11 11 11 ? 每年的11月11号 11点11分触发(光棍节)
        定时批处理作业是J2EE企业应用里很重要的一环，用来在晚间进行财务挂账，数据转存，新闻联播等等操作。
     */

//    //测试的两秒执行执行一次
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void dailySchedule(){
//        System.out.println("2秒执行一次");
//    }


    @Autowired
    ScheduleTask scheduleTask;
    @Autowired
    EmailMQFeign emailService;
    @Autowired
    NotApiServiceImpl notApiService;

    //每天0点执行一次:0 0 0 * * ?
    @Scheduled(cron = "0 0 0 * * ?")
    public void Schedule1() throws Exception {
        System.out.println("【定时任务】每日任务添加");
        scheduleTask.dailyScheduleTask();
    }

    //每一个整点执行一次:0 0 * * * ?
    @Scheduled(cron = "0 0 * * * ?")
    public void Schedule2() throws Exception {
        System.out.println("整点定时任务");
        EmailPO emailPO=new EmailPO();
        emailPO.setSubject("【每日壁纸推荐】");
        emailPO.setContent(notApiService.getWallhavenPic());
        emailService.emailSendToAdmin(emailPO);
        emailPO.setContent(notApiService.getWBHotMessage());
        emailPO.setSubject("微博热搜【1小时刷新1次】");
    }

    //每隔2个小时执行一次:0 0 0/2 * * ?
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void Schedule3() throws Exception {
//        System.out.println("2小时定时任务");
    }

    //每隔1分钟秒执行一次:0 * * * * ?
    @Scheduled(cron = "0 0/1 * * * ?")
    public void Schedule4() throws Exception {
//        System.out.println("5分钟定时任务");
    }

    //12点05分执行:0 0 0/12 * * ?
    @Scheduled(cron = "0 0/5 0/12 * * ?")
    public void Schedule5() throws Exception {
//        System.out.println("12点05分定时任务");
    }

    //整点05分执行:0 0 0/12 * * ?
    @Scheduled(cron = "0 0/5 * * * ?")
    public void Schedule6() throws Exception {
//        System.out.println("12点05分定时任务");
    }

    //5秒执行:0 0 0/5 * * ?
    @Scheduled(cron = "0/5 * * * * ?")
    public void Schedule7() throws Exception {
//        EmailPO emailPO=new EmailPO();
//        emailPO.setContent(notApiService.getWBHotMessage());
//        emailPO.setSubject("微博热搜【1小时刷新1次】");
//        emailPO.setTitle("微博热搜【1小时刷新1次】");
//        System.out.println("5秒定时任务");
//        emailService.emailSendToAdmin(emailPO);

//        scheduleTask.dailyScheduleTask();
    }
}
