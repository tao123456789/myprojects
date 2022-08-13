package com.example.common.Api;

import org.springframework.web.bind.annotation.RestController;

public interface TokenService {
    String createToken(int id,String name);

    Integer checkToken(String token);
    void insertToken(String token);
}
