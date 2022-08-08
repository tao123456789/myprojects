package com.example.token.Config.FeignConf;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class FeignConfig implements RequestInterceptor {
    @Override
    public void apply (RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token=request.getHeader("token");
        //添加token
        System.out.println("Feign接口传递token值"+token);
        requestTemplate.header("token", token);
    }
}
