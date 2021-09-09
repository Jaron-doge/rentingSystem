package com.example.rent.entity;

/**
 * 用户实体类
 */
public class User {
    private  Integer userId;
    private  String userName;
    private  String  userPwd;
    private  String icon;
    private  String telephone;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" +userId+
                ", username='" + userName + '\'' +
                ", password='" + userPwd + '\'' +
                ", icon='" + icon + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
