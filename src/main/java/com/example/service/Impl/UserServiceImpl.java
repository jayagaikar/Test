package com.example.service.Impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



   public class UserServiceImpl implements UserServiceI {

       @Autowired
       private UserRepository userRepository;


    @Override
    public User createUser(User user) {
       User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        return null;
    }

    @Override
    public User getSingleUSer(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }


   }
