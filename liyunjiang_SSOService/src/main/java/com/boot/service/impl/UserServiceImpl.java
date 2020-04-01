package com.boot.service.impl;

import com.boot.dao.IUserDao;
import com.boot.entity.UserEntity;
import com.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addUser(UserEntity user) {
        userDao.save(user);
    }

    @Override
    public UserEntity login(String loginName, String password) {
        return userDao.login(loginName,password);
    }
}
