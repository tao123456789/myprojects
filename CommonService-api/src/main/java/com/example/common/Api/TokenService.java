package com.example.common.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/token")
public interface TokenService {
    String createToken(int id,String name);

    Integer checkToken(String token);
    void insertToken(String token);
}
