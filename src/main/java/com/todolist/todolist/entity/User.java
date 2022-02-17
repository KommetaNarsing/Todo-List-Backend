package com.todolist.todolist.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "user", schema = "public")
public class User {

    @Id
    @Column(name = "userid")
    private  String userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    public User(String userId){
        this.userId = userId;
    }

    public User(){

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
