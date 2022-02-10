package com.todolist.todolist.dao;

import com.todolist.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoItemDao {

    private JdbcTemplate jdbcTemplate;

    public TodoItemDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(final TodoItem item){
        String sql = "INSERT INTO todo_item (id, description, user_id, timestamp) VALUES ("
                + "?,?,?,?)";
        int rows = jdbcTemplate.update(sql, ps -> {
                    ps.setString(1, item.getTodoItemId());
                    ps.setString(2,item.getDescription());
                    ps.setString(3,item.getUserId());
                    ps.setLong(4,item.getTimeStamp());
        });
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
}
