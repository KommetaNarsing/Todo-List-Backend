package com.todolist.todolist.controller;

import com.todolist.todolist.entity.TodoItem;
import com.todolist.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @CrossOrigin
    @PostMapping(path = "/add",consumes = {"application/json"})
    public String addItem(@RequestBody TodoItem item, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        todoService.addTodoItem(item);
        return item.getTodoItemId();
    }

    @CrossOrigin
    @GetMapping(path = "/list")
    public List<TodoItem> getItems(){
       return  todoService.fetch();
    }

}
