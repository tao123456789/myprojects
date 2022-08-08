package com.example.gbf.GBFservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GBFTest")
public interface GBFTestService {
    @GetMapping("/getMessage")
    String GBFTest();
}
