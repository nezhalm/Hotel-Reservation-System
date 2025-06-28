package com.hotel.entity;

public class User {
    private int id;
    private int balance;

    public User(int id, int balance) {
     if (id <= 0) {
    throw new IllegalArgumentException("User ID must be greater than zero.");
}
if (balance < 0) {
    throw new IllegalArgumentException("Initial balance cannot be negative.");
}

        this.id = id;
        this.balance = balance;
    }

    public int getUserId() {
        return id;
    }

 
    public int getBalance() {
        return balance;
    }


    public void debit(int amount) throws IllegalArgumentException {
     if (amount < 0) {
    throw new IllegalArgumentException("Amount to debit cannot be negative.");
}
if (amount > this.balance) {
    throw new IllegalArgumentException("Insufficient balance to debit " + amount + " MAD.");
}

        this.balance -= amount;
    }



}
