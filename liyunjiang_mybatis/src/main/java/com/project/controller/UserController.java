package com.project.controller;

import com.project.bean.UserBean;
import com.project.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("/reg")
    @ResponseBody
    public String register(@RequestBody UserBean user){
        userService.addUser(user);
        return "ok";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserBean user){
        System.out.println("登录:"+user.getLoginName()+"  "+user.getPassword());
        UserBean resultUser=userService.login(user.getLoginName(),user.getPassword());
        if (resultUser==null){
            return "no";
        }
        return "ok";
    }
}
