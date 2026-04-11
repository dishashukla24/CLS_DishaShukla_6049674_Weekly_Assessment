package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User getUser(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        return repo.save(user);
    }
    public java.util.List<User> getAllUsers() {
        return repo.findAll();
    }
}