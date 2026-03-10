package com.gemfire.demo.controller;

import com.gemfire.demo.domain.User;
import com.gemfire.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return service.getUser(id).orElse(null);
    }
}
