package com.todolist.todolist.controller;

import com.todolist.todolist.dao.TodoItemDao;
import com.todolist.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/todo")
public class MainController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @PostMapping(path = "/add",consumes = {"application/json"})
    public String addItem(@RequestBody TodoItem item){
        new TodoItemDao(jdbcTemplate).insert(item);
        return "Success";
    }

}
