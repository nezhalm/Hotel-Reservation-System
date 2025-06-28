package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.hotel.entity.User;
import com.hotel.service.IUserService;

public class UserServiceImpl implements IUserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public void setUser(int userId, int balance) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Invalid user balance.");
        }

        for (User user : users) {
            if (user.getUserId() == userId) {
                System.out.println("User already exists: " + userId);
                return;
            }
        }

        User newUser = new User(userId, balance);
        users.add(newUser);
        System.out.println("User added: " + userId);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users); // returns a copy
    }

    @Override
    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        throw new NoSuchElementException("User with ID " + userId + " not found.");
    }

    @Override
    public void printAllUsers() {

        try {
            System.out.println("\n=== USERS ===");
            for (User user : users) {
                System.out.println("User " + user.getUserId() +
                        " | Balance: " + user.getBalance());
            }
        } catch (Exception e) {
            System.err.println("Error in printAllUsers: " + e.getMessage());
        }
    }
}
