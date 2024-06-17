package com.example.service.Impl;

import ch.qos.logback.core.joran.action.NewRuleAction;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceI;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserServiceI {

       @Autowired
       private UserRepository userRepository;


    @Override
    public User createUser(User user) {
       User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(@NotNull User user, Long userId) {
        User user1 = userRepository.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser= userRepository.save(user1);
        return updatedUser;
    }

    @Override
    public User getSingleUSer(Long userId)  {
      User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource Not found Exception !!" + userId));

        return user;
       /* Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()){
            return user.get();
        } else {
            throw new Exception("Resource not found !!!"  +userId);
        } */
    }

    @Override
    public List<User> getAllUsers() {
       List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public void deleteUser(Long userId) {

      User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Resource not found Exception !!" + userId));

      userRepository.delete(user);

    }


   }
