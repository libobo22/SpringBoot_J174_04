package com.project.bean;


/**
 * 用户实体类
 */
public class UserBean{

    private Integer userId;
    private String userName;
    private String loginName;
    private String password;
    private String userStatus="1";

    public UserBean() {
    }

    public UserBean(String userName, String loginName, String password, String userStatus) {
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
        this.userStatus = userStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }


}
