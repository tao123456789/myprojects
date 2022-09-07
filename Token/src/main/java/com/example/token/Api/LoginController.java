package com.example.token.Api;

import com.example.MQService.Entity.PO.EmailPO;
import com.example.common.Entity.VO.UserModuleVO;
import com.example.token.Utils.feign.CommonServiceFeign;
import com.example.common.Entity.BO.User.UserBO;
import com.example.common.Entity.PO.RedisPO.RedisPO;
import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.PassToken;
import com.example.token.Utils.basicEnum.ResultCode;
import com.example.token.Utils.BasicClass.BasicResponse;
import com.example.token.Utils.feign.EmailMQFeign;
import com.example.token.Utils.http.HttpUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@PassToken
@RestController
@CrossOrigin
@RequestMapping("/")
@Api(tags = "用户登录")
public class LoginController{
    @Value("${server.port}")
    private String port;

    private int sum=0;

    @Autowired
    private CommonServiceFeign commonServiceFeign;
    @Autowired
    private EmailMQFeign emailMQFeign;
    @Resource
    HttpUtil httpUtil;
    @Resource
    HttpServletRequest httpServletRequest;

    //登录
    @PostMapping ("/login")
    @ResponseBody
    @AspectLogAnnptation
    public String login(@RequestBody UserBO userBO) {
        UserBO userBean = new UserBO();
        System.out.println(userBO.toString());
        userBean = commonServiceFeign.GetUserByUserName(userBO.getUserName());
        System.out.println("获取当前用户信息："+userBean);
        //验证登录，获取token
        if(userBean.getUserPasswd().equals(userBO.getUserPasswd())){
            userBO.setId(userBean.getId());
            userBO.setRealName(userBean.getRealName());
            userBO.setIp(httpUtil.getIpAddr(httpServletRequest));
            userBO.setBrower(HttpUtil.getLoginInfo().getBrower());
            userBO.setOs(HttpUtil.getLoginInfo().getOs());
            //生成token
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            try{
                RedisPO redisPO=new RedisPO();
                redisPO.setKey(token);
                redisPO.setTime(1);
                redisPO.setTimeUnit(TimeUnit.HOURS);
                redisPO.setValue(userBO.getId());
                //保存token,key为token,value为id,有效期为1个小时
                commonServiceFeign.set(redisPO);
                //更新登录信息
                if(commonServiceFeign.updateUser(userBO)==1){
                    System.out.println("用户登录信息更新成功！");
                }else{
                    System.out.println("用户登录信息更新失败！");
                };
                String content="【登录提醒】尊敬的管理员，您好，用户： "+ userBO.getRealName()+"("+ userBO.getUserName()+") 正使用IP地址： 【"+ HttpUtil.getLoginInfo().getIp()
                        + "】 于 【"+ userBO.getLogintime()+"】 位于 【"+ userBO.getArea()+"】 区域使用 【"
                        + HttpUtil.getLoginInfo().getOs()+"】 操作系统的 【"+ HttpUtil.getLoginInfo().getBrower()+"】 浏览器登录您的系统！";
                EmailPO emailPO=new EmailPO();
                emailPO.setContent(content);
                emailPO.setSubject("【登录提醒】");
                emailMQFeign.emailSendToAdmin(emailPO);
                return token;
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("登录密码错误！！！");
        }
        return "false";
    }

    @PostMapping("/register")
    @ResponseBody
    @AspectLogAnnptation
    public BasicResponse register(@RequestBody UserBO userBO) throws Exception {
        System.out.println(userBO.toString());
        UserBO userBO1=new UserBO();
        userBO1.setInviteAuth(userBO.getBeinviteauth());
        if(commonServiceFeign.GetAllUser(userBO1).isEmpty()){
            return new BasicResponse(ResultCode.ERROR,"邀请码不存在！！！");
        }else{
            userBO1.setInviteAuth(null);
            userBO1.setUserName(userBO.getUserName());
            if(!commonServiceFeign.GetAllUser(userBO1).isEmpty()){
                return new BasicResponse(ResultCode.ERROR,"用户名已存在！！！");
            }else {
                String password=UUID.randomUUID().toString().replaceAll("-", "");
                userBO.setIp(httpUtil.getIpAddr(httpServletRequest));
                userBO.setBrower(HttpUtil.getLoginInfo().getBrower());
                userBO.setOs(HttpUtil.getLoginInfo().getOs());
                userBO.setRealName("游客");
                userBO.setUserPasswd(password);
                userBO.setInviteAuth(UUID.randomUUID().toString().replaceAll("-", ""));
                System.out.println(userBO);
                if ((commonServiceFeign.insertUser(userBO) == 1)) {
                    UserModuleVO userModuleVO=new UserModuleVO();
                    System.out.println("==================="+commonServiceFeign.GetUserByUserName(userBO.getUserName()).getId());
                    userModuleVO.setUserid(commonServiceFeign.GetUserByUserName(userBO.getUserName()).getId());
                    //初始化只赋予个人模块的权限
                    userModuleVO.setModuleid(1);
                    commonServiceFeign.insertUserModule(userModuleVO);
                    return new BasicResponse(ResultCode.SUCCESS,password);
                }
            }
        }
        return new BasicResponse(ResultCode.ERROR,"注册失败！！！");
    }

    @PassToken
    @GetMapping("/getMessage")
    public String getMessage() throws Exception {
        EmailPO emailPO=new EmailPO();
        emailMQFeign.emailSendToAdmin(emailPO);
        synchronized(this) {
            sum = sum + 1;
            System.out.println(sum + "你已通过验证：端口号为：" + port);
        }
        return "你已通过验证：端口号为："+ port;
    }
}
