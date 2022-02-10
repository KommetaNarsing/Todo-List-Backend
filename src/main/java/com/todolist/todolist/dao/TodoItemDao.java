package com.todolist.todolist.dao;

import com.todolist.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public List<TodoItem> fetch(){
        String sql = "SELECT * from todo_item";
        return  jdbcTemplate.query(sql, new RowMapper<TodoItem>() {
            @Override
            public TodoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
                TodoItem todoItem = new TodoItem();
                todoItem.setTodoItemId(rs.getString("id"));
                todoItem.setDescription(rs.getString("description"));
                todoItem.setUserId(rs.getString("user_id"));
                todoItem.setTimeStamp(rs.getLong("timestamp"));
                return todoItem;
            }
        });

    }
}
