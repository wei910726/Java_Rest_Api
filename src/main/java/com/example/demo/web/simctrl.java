package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//自定义配置测试
@RestController
public class simctrl {
    @Value("${cn.full_me}")
    private String full;

    @GetMapping(value="/test/")
    public String hello(){
        return full;
    }
}
