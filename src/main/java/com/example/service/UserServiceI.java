package com.example.service;

import com.example.model.User;

import java.util.List;


public interface UserServiceI {

    User createUser(User user);

    User updateUser(User user, Long userId);

    User getSingleUSer (Long userId) throws Exception;

    List<User> getAllUsers();

    void deleteUser (Long userId);
}
