package com.boot.service;

import com.boot.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public void addUser(UserEntity user);
    public UserEntity login(String loginName,String password);
    public List<UserEntity> findAllUserList();
    public UserEntity findById(Integer userId);
    public void updateUserById(Integer userId,String loginName, String password);
    public void delUserById(Integer userId);
}
