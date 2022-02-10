package com.todolist.todolist.controller;

import com.todolist.todolist.dao.TodoItemDao;
import com.todolist.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(path = "/todo")
public class MainController {

    @Autowired

    JdbcTemplate jdbcTemplate;

    @PostMapping(path = "/add",consumes = {"application/json"})
    public String addItem(@RequestBody TodoItem item){
        item.setTodoItemId(UUID.randomUUID().toString());
        new TodoItemDao(jdbcTemplate).insert(item);
        return item.getTodoItemId();
    }

    @GetMapping(path = "/list")
    public List<TodoItem> getItems(){
       return  new TodoItemDao(jdbcTemplate).fetch();
    }

}
