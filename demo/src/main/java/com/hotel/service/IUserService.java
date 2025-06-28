package com.hotel.service;

import java.util.List;

import com.hotel.entity.User;

public interface IUserService {
    void setUser(int userId, int balance);
    List<User> getAllUsers();
    User getUserById(int userId);
    void printAllUsers();

}
