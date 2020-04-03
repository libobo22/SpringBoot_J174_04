package com.boot.controller;

import com.boot.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GotoPage {
    @RequestMapping("/gotoListPage")
    public ModelAndView gotoListPage(){
        ModelAndView mv=new ModelAndView("listPage");
        UserEntity user=new UserEntity();
        user.setLoginName("abc");
        user.setPassword("123123");
        mv.addObject("user",user);
        System.out.println("gotoListPage");
        return mv;
    }
    @RequestMapping("/gotoAddUserPage")
    public String gotoAddUserPage(){
        return "addUserPage";
    }
    @RequestMapping("/gotoLogin")
    public String gotoLogin(){
        return "power/login";
    }
}
