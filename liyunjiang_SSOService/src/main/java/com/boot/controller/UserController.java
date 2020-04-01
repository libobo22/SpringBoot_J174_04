package com.boot.controller;

import com.boot.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("hello")
    public String hello(){
        return "hello boot";
    }
    @RequestMapping("/reg")
    public String reg(@RequestBody UserEntity user){
        System.out.println("注册:"+user.getLoginName()+"  "+user.getPassword());
        return "ok";
    }
    @RequestMapping("/login")
    public String login(@RequestBody UserEntity user){
        System.out.println("登录:"+user.getLoginName()+"  "+user.getPassword());
        return "ok";
    }
}
