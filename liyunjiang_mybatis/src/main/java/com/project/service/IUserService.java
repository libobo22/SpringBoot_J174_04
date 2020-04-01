package com.project.service;

import com.project.bean.UserBean;

public interface IUserService {
    public void addUser(UserBean user);
    public UserBean login(String loginName,String password);
}
