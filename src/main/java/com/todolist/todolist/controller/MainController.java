package com.todolist.todolist.controller;

import com.todolist.todolist.dao.TodoItemDao;
import com.todolist.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/todo")
public class MainController {

    @Autowired

    JdbcTemplate jdbcTemplate;

    @PostMapping(path = "/add",consumes = {"application/json"})
    public String addItem(@RequestBody TodoItem item){
        new TodoItemDao(jdbcTemplate).insert(item);
        return "Success";
    }

    @GetMapping(path = "/list")
    public List<TodoItem> getItems(){
       return  new TodoItemDao(jdbcTemplate).fetch();
    }

}
