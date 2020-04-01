package com.boot.controller;

import com.boot.entity.UserEntity;
import com.boot.service.IUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;
    @RequestMapping("hello")
    public String hello(){
        return "hello boot";
    }
    @RequestMapping("/reg")
    public String reg(@RequestBody UserEntity user){
        System.out.println("注册:"+user.getLoginName()+"  "+user.getPassword());
        userService.addUser(user);
        return "ok";
    }
    @RequestMapping("/login")
    public String login(@RequestBody UserEntity user){
        System.out.println("登录:"+user.getLoginName()+"  "+user.getPassword());
        UserEntity resultUser=userService.login(user.getLoginName(),user.getPassword());
        if (resultUser==null){
            return "no";
        }
        return "ok";
    }
}
