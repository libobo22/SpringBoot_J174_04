package com.boot.dao;

import com.boot.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserEntity,Integer> {
    @Query("from UserEntity where loginName=?1 and password=?2")
    public UserEntity login(String loginName,String password);
}
