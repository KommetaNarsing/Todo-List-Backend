package com.todolist.todolist.service;

import com.todolist.todolist.entity.User;
import com.todolist.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User adduser(String userName, String password){
        User user = new User(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public Optional<User> fetch(String userId){
        return userRepository.findById(userId);
    }

}
