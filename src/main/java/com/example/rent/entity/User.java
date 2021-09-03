package com.example.rent.entity;

/**
 * 用户实体类
 */
public class User {
    private  Integer userId;
    private  String userName;
    private  String  userPwd;
    private  Integer icon;

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



    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userId +
                ", username='" + userName + '\'' +
                ", password='" + userPwd + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
