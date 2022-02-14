package com.todolist.todolist.controller;

import com.todolist.todolist.dao.UserDao;
import com.todolist.todolist.entity.TodoItem;
import com.todolist.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @PostMapping(path = "/signin",consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<User> addItem(@RequestParam String username, @RequestParam String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
       if(httpServletRequest.getCookies() != null){

           return ResponseEntity.ok().body(fetch(username));
       }
       else {
           User user = new User();
           user.setUserId(UUID.randomUUID().toString());
           user.setUserName(username);
           user.setPassword(password);
           new UserDao(jdbcTemplate).insert(user);
           ResponseCookie cookie = ResponseCookie.from("sessionid", user.getUserId()).build();
           return ResponseEntity.ok().header("Set-Cookie",cookie.toString()).build();
       }
    }

    @CrossOrigin
    @GetMapping(path = "/getuser")
    private ResponseEntity<User> fetch(HttpServletRequest httpServletRequest){
        if(httpServletRequest.getCookies() != null){
            String userid = Arrays.stream(httpServletRequest.getCookies())
                    .filter(cookie -> cookie.getName() != "sessionid").findFirst().get().getValue();
            return ResponseEntity.ok().body(fetch(userid));
        }
        return ResponseEntity.status(401).body(new User());
    }

    private User fetch(String userid){
        String sql = "SELECT * from public.user where userid="+ "'"+userid+ "'" + ";";
        return  jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserId(rs.getString("userid"));
                return user;
            }
        });
    }
}
