package com.gemfire.demo.service;

import com.gemfire.demo.domain.User;
import com.gemfire.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {

        if(user.getAge() == null){
            user.setAge(0);
        }

        if(user.getActive() == null){
            user.setActive(false);
        }

        return repository.save(user);
    }

    public Optional<User> getUser(String id){
        return repository.findById(id);
    }
}
