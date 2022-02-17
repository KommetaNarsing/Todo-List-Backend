package com.todolist.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "todo_item", schema = "public")
public class TodoItem {

    @Id
    private String id;
    private String description;

    @Column(name = "user_id")
    private String userId;

    private long timestamp;

    public long getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timestamp = timeStamp;
    }

    public String getTodoItemId() {
        return id;
    }

    public void setTodoItemId(String todoItemId) {
        this.id = todoItemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
