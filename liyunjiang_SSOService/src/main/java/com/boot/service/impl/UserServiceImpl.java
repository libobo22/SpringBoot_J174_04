package com.boot.service.impl;

import com.boot.dao.IUserDao;
import com.boot.dto.UserPermissionDTO;
import com.boot.entity.UserEntity;
import com.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public UserEntity findById(Integer userId) {
        return userDao.findById(userId).get();
    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delUserById(Integer userId) {
        userDao.deleteById(userId);
    }

    @Override
    public List<UserPermissionDTO> findPermissionByLoginName(String loginName) {
        List<Object[]> objList=userDao.findPermissionByLoginName(loginName);
        List<UserPermissionDTO> list=null;
        if (objList!=null&&objList.size()!=0){
            list=new ArrayList<>();
            for (Object[] obj:
                    objList) {
                UserPermissionDTO userPerDto= new UserPermissionDTO();
                userPerDto.setUserName((String) obj[0]);
                userPerDto.setPerName((String) obj[1]);
                userPerDto.setPerURL((String) obj[2]);
                list.add(userPerDto);
            }
        }
        return list;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateUserById(Integer userId, String loginName, String password) {
        userDao.updateUserById(userId,loginName,password);
    }

    @Override
    public List<UserEntity> findAllUserList() {
        return (List<UserEntity>) userDao.findAll();
    }
}
