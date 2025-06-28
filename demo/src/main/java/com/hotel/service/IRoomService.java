package com.hotel.service;

import java.util.List;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;

public interface IRoomService {
    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight);
    List<Room> getAllRooms();
    Room getRoomByNumber(int roomNumber);

}