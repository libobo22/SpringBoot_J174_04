package com.boot.controller;

import com.boot.entity.UserEntity;
import com.boot.service.IUserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/leaf")
public class LeafUserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/addUser")
      public ModelAndView addUser(UserEntity user){
          ModelAndView mv=new ModelAndView();
          userService.addUser(user);
          RedirectView rv=new RedirectView("findAllUserList");
          mv.setView(rv);
          return mv;
      }

  @RequestMapping("/findAllUserList")
  public ModelAndView findAllUserList(){
      ModelAndView mv=new ModelAndView("listPageInfo");
      List<UserEntity> userList=userService.findAllUserList();
      mv.addObject("userList",userList);
      return mv;
  }
  @RequestMapping("/updateUserShow")
  public ModelAndView updateUserShow(Integer userId){
      ModelAndView mv=new ModelAndView("updateUserPage");
      UserEntity user=userService.findById(userId);
      mv.addObject("user",user);

      return mv;
  }
    @RequestMapping("/updateUser")
  public ModelAndView updateUser(Integer userId,String loginName,String password){
      ModelAndView mv=new ModelAndView();
      userService.updateUserById(userId,loginName,password);
      RedirectView rv=new RedirectView("findAllUserList");
      mv.setView(rv);
      return mv;
  }
    @RequestMapping("/delUser")
    public ModelAndView delUser(Integer userId){
        ModelAndView mv=new ModelAndView();
        userService.delUserById(userId);
        RedirectView rv=new RedirectView("findAllUserList");
        mv.setView(rv);
        return mv;
    }
}
