package com.hotel.entity;

public class Room {
    private int roomNumber;
    private RoomType type;
    private int pricePerNight;

    // Constructeur
    public Room(int roomNumber, RoomType type, int pricePerNight) {
    if (roomNumber <= 0) {
    throw new IllegalArgumentException("Room number must be greater than zero.");
}
if (type == null) {
    throw new IllegalArgumentException("Room type cannot be null.");
}
if (pricePerNight < 0) {
    throw new IllegalArgumentException("Price per night cannot be negative.");
}


        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

}
