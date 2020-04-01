package com.project.service.impl;

import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserBean user) {
        userDao.addUser(user);
    }

    @Override
    public UserBean login(String loginName, String password) {
        return userDao.login(loginName,password);
    }
}
