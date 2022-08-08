package com.example.token.Service.NotApiService;

import com.example.token.Utils.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class NotApiServiceImpl {

    @Resource
    HttpUtil httpUtil;

    public String getWBHotMessage(){
        HashMap hashMap=new HashMap();
        hashMap.put("cookie","SUB=1");
        String response=httpUtil.getMethod("https://s.weibo.com/top/summary?cate=realtimehot",hashMap);
        List<String> content= Arrays.asList(StringUtils.substringsBetween(response, "target=\"_blank\">", "</a>"));
//        List<String> level= Arrays.asList(StringUtils.substringsBetween(response, "<td class=\"td-01 ranktop\">", "</td>"));
        String WBhotMessage="";
        for(int i=0;i<content.size();i++){
            WBhotMessage=WBhotMessage+content.get(i)+"<br>";
        }
        return WBhotMessage;
    }

    public String getWallhavenPic(){
        String response=httpUtil.getMethod("https://wallhaven.cc/random");
        List<String> content= Arrays.asList(StringUtils.substringsBetween(response, "<a class=\"preview\" href=\"", "\"  target=\"_blank\"  >"));
        List<String> content2=new ArrayList<>();
        for(String item:content){
            System.out.println("正在获取壁纸链接..."+item);
            String response2=httpUtil.getMethod(item);
            content2.add(Arrays.asList(StringUtils.substringsBetween(response2, "<img id=\"wallpaper\" src=\"", "\" alt=\"")).get(0));
        }
//        System.out.println("共获取到"+content2.size()+"张壁纸");
        String WallhavenPic="共获取到"+content2.size()+"张壁纸<br>";
        for(String item:content2){
            System.out.println(WallhavenPic);
            WallhavenPic=WallhavenPic+"<br>"+item+"<br><img src=\""+item+"\">";
        }
//        System.out.println(WallhavenPic);
        return WallhavenPic;
    }
}
