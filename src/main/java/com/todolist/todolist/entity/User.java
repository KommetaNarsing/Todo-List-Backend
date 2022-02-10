package com.todolist.todolist.entity;

public class User {

    private String userName;
    private  String emailId;
    private  String userId;
    private long timeStamp;

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


    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
