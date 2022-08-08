package com.example.gbf.util.IPUtil;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class IPUtil {
    public static String getIP(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        System.out.println("ip:" + ip);
        String headerIP = request.getHeader("x-real-ip");
        if (headerIP == null || "".equals(headerIP) || "null".equals(headerIP)) {
            headerIP = request.getHeader("x-forwarded-for");
        }
        System.out.println("headerIP:" + headerIP);
        if (headerIP != null && !"".equals(headerIP) && !"null".equals(headerIP)) {
            ip = headerIP;
        }
        return ip;
    }
}
