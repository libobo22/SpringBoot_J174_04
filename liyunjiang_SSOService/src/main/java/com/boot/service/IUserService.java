package com.boot.service;

import com.boot.entity.UserEntity;

public interface IUserService {
    public void addUser(UserEntity user);
    public UserEntity login(String loginName,String password);
}
