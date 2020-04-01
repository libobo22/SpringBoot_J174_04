package com.project.dao;

import com.project.bean.UserBean;

public interface IUserDao {
    public void addUser(UserBean user);
    public UserBean login(String loginName,String password);
}
