package com.todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/todo")
public class MainController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping(path = "/add")
    public String addItem(){
        String sql = "INSERT INTO todo_item (item_description, item_id) VALUES ("
                + "'Second item', '1234')";
        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
        return "Success";
    }

}
