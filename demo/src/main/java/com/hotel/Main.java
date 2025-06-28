package com.hotel;

import java.text.SimpleDateFormat;

import com.hotel.entity.RoomType;
import com.hotel.service.IRoomService;
import com.hotel.service.impl.BookingServiceImpl;
import com.hotel.service.impl.RoomServiceImpl;
import com.hotel.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        IRoomService roomService = new RoomServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl(roomService, userService);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Create Rooms
        roomService.setRoom(1, RoomType.STANDARD, 1000);
        roomService.setRoom(2, RoomType.JUNIOR, 2000);
        roomService.setRoom(3, RoomType.SUITE, 3000);

        // Create Users
        userService.setUser(1, 5000);
        userService.setUser(2, 10000);




        // Bookings
        // bookingService.bookRoom(1, 2, sdf.parse("30/06/2026"), sdf.parse("07/07/2026")); // fail (5000 < 14000)
        // bookingService.bookRoom(1, 2, sdf.parse("07/07/2026"), sdf.parse("30/06/2026")); // invalid dates
         bookingService.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("08/07/2026")); // success
        // bookingService.bookRoom(2, 1, sdf.parse("07/07/2026"), sdf.parse("09/07/2026")); // overlap fail
         bookingService.bookRoom(2, 3, sdf.parse("07/07/2026"), sdf.parse("08/07/2026")); // success

        // Modify room (should not affect bookings)
        roomService.setRoom(1, RoomType.SUITE, 10000);

        // Print everything
        userService.printAllUsers();
        bookingService.printAll();
    }
}
