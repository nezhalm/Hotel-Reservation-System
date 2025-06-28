package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.service.IRoomService;

public class RoomServiceImpl implements IRoomService {

    private final List<Room> rooms;

    public RoomServiceImpl() {
        this.rooms = new ArrayList<>();
    }

    @Override
    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        try {
            if (roomNumber <= 0) {
                throw new IllegalArgumentException("Invalid room number.");
            }
            if (roomType == null) {
                throw new IllegalArgumentException("Room type is required.");
            }
            if (roomPricePerNight < 0) {
                throw new IllegalArgumentException("Price per night cannot be negative.");
            }

            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {
                    System.out.println("Room already exists, no changes made.");
                    return;
                }
                if (room.getType() == roomType && room.getPricePerNight() == roomPricePerNight) {
                    System.out.println("A room with the same type and price already exists. Addition ignored.");
                    return;
                }
            }

            Room newRoom = new Room(roomNumber, roomType, roomPricePerNight);
            rooms.add(0, newRoom);
            System.out.println("Room " + roomNumber + " created.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error in setRoom: " + e.getMessage());
        }
    }

    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    @Override
    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
