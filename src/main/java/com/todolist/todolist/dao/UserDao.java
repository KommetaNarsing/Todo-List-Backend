package com.todolist.todolist.dao;

import com.todolist.todolist.entity.TodoItem;
import com.todolist.todolist.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(final User user){
        String sql = "INSERT INTO public.user (userid, username, password) VALUES ("
                + "?,?,?)";
        int rows = jdbcTemplate.update(sql, ps -> {
            ps.setString(1, user.getUserId());
            ps.setString(2,user.getUserName());
            ps.setString(3,user.getPassword());
        });
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
}
