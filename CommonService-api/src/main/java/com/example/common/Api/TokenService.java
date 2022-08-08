package com.example.common.Api;

public interface TokenService {
    String createToken(int id,String name);

    Integer checkToken(String token);
    void insertToken(String token);
}
