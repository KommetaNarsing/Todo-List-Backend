package com.todolist.todolist.entity;

public class TodoItem {
    private String id;
    private String description;
    private String userId;
    private long timeStamp;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
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
