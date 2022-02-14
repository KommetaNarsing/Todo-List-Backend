package com.todolist.todolist.controller;

import com.todolist.todolist.dao.TodoItemDao;
import com.todolist.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/todo")
public class MainController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @PostMapping(path = "/add",consumes = {"application/json"})
    public String addItem(@RequestBody TodoItem item, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        item.setTodoItemId(UUID.randomUUID().toString());
        new TodoItemDao(jdbcTemplate).insert(item);
        return item.getTodoItemId();
    }

    @CrossOrigin
    @GetMapping(path = "/list")
    public List<TodoItem> getItems(){
       return  new TodoItemDao(jdbcTemplate).fetch();
    }

}
