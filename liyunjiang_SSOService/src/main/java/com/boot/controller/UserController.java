package com.boot.controller;

import com.boot.dto.UserPermissionDTO;
import com.boot.entity.UserEntity;
import com.boot.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello boot";
    }
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(@RequestBody UserEntity user){
        System.out.println("注册:"+user.getLoginName()+"  "+user.getPassword());
        userService.addUser(user);
        return "ok";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserEntity user){
        System.out.println("登录:"+user.getLoginName()+"  "+user.getPassword());
        UserEntity resultUser=userService.login(user.getLoginName(),user.getPassword());
        if (resultUser==null){
            return "no";
        }
        return "ok";
    }
    @RequestMapping("/power/login")
    public ModelAndView powerLogin(UserEntity user, HttpServletRequest request){
        System.out.println("登录:"+user.getLoginName()+"  "+user.getPassword());
        UserEntity resultUser=userService.login(user.getLoginName(),user.getPassword());
        ModelAndView mv=new ModelAndView();
        if (resultUser==null){
            mv.setViewName("power/login");
            return mv;
        }
        request.getSession().setAttribute("currentUser",resultUser);
        List<UserPermissionDTO> list=userService.findPermissionByLoginName(user.getLoginName());
        request.getSession().setAttribute("powerList",list);
        mv.addObject("powerList",list);
        mv.setViewName("power/showPower");
        return mv;
    }
}
