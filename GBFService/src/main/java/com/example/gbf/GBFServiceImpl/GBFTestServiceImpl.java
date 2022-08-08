package com.example.gbf.GBFServiceImpl;

import com.example.gbf.GBFservice.GBFTestService;
import com.example.gbf.util.IPUtil.IPUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class GBFTestServiceImpl implements GBFTestService {

    @Override
    public String GBFTest() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        System.out.println("请求的IP地址："+ IPUtil.getIP(request));
        return "调用成功";
    }
}
