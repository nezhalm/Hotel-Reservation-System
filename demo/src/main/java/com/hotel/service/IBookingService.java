package com.hotel.service;

import java.util.Date;
import java.util.List;

import com.hotel.entity.Booking;

public interface IBookingService {
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) throws Exception;
    List<Booking> getAllBookings();
    void printAll();

}