package com.todolist.todolist.entity;

import java.security.PrivateKey;

public class User {

    private String userName;
    private  String emailId;
    private  String userId;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserId() {
        return userId;
    }

}
