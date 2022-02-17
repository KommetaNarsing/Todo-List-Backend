package com.todolist.todolist.controller;

import com.todolist.todolist.entity.User;
import com.todolist.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(path = "/signin",consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<User> addItem(@RequestParam String username, @RequestParam String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
       if(httpServletRequest.getCookies() != null){
           return ResponseEntity.ok().body(null);
       }
       else {
           User user = userService.adduser(username,password);
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
            Optional<User> user = userService.fetch(userid);
            if(user.isPresent()){
                return ResponseEntity.ok().body(user.get());
            }

        }
        return ResponseEntity.status(401).body(null);
    }

//    private User fetch(String userid){
//        String sql = "SELECT * from public.user where userid="+ "'"+userid+ "'" + ";";
//        return  jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User user = new User();
//                user.setUserName(rs.getString("username"));
//                user.setPassword(rs.getString("password"));
//                user.setUserId(rs.getString("userid"));
//                return user;
//            }
//        });
//    }
}
