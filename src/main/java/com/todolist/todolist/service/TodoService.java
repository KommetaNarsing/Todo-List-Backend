package com.todolist.todolist.service;

import com.todolist.todolist.entity.TodoItem;
import com.todolist.todolist.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    TodoItemRepository todoItemRepository;

    public void addTodoItem(TodoItem todoItem){
        todoItem.setTodoItemId(UUID.randomUUID().toString());
        todoItemRepository.save(todoItem);
    }

    public List<TodoItem> fetch(){
        List<TodoItem> linkedList = new LinkedList<>();
        todoItemRepository.findAll().forEach(item -> linkedList.add(item));
        return linkedList;
    }
}
