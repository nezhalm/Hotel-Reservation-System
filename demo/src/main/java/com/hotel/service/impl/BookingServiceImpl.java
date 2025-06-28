package com.hotel.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hotel.entity.Booking;
import com.hotel.entity.Room;
import com.hotel.entity.User;
import com.hotel.service.IBookingService;
import com.hotel.service.IRoomService;
import com.hotel.service.IUserService;

public class BookingServiceImpl implements IBookingService {

    private final IRoomService iRoomService;
    private final IUserService iUserService;

    private final List<Booking> bookings = new ArrayList<>();

    public BookingServiceImpl(IRoomService iRoomService, IUserService iUserService) {
        this.iRoomService = iRoomService;
        this.iUserService = iUserService;
    }

    @Override
    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) throws Exception {
        if (checkIn == null || checkOut == null) {
         throw new IllegalArgumentException("Dates cannot be null.");
        }

        if (!checkIn.before(checkOut)) {
        throw new IllegalArgumentException("Check-in date must be before check-out date.");
        }

        Room selectedRoom = this.iRoomService.getRoomByNumber(roomNumber);

if (selectedRoom == null) throw new Exception("Room not found.");


        User selectedUser = this.iUserService.getUserById(userId);

if (selectedUser == null) throw new Exception("User not found.");

        // Vérifier disponibilité
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber && booking.isOverlapping(checkIn, checkOut)) {
throw new Exception("The room is already booked for this period.");
            }
        }

        // Calcul du coût
        long days = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);

        if (days <= 0) days = 1; 
        long totalCost = days * selectedRoom.getPricePerNight();

        if (selectedUser.getBalance() < totalCost) {
throw new Exception("Insufficient balance. Total price = " + totalCost);
        }

        // Débit et réservation
        selectedUser.debit((int) totalCost);
        Booking newBooking = new Booking(selectedUser, selectedRoom, checkIn, checkOut, (int) totalCost);
        bookings.add(0, newBooking);
System.out.println("Booking successful for user " + userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }
   @Override
public void printAll() {
  System.out.println("\n===== CURRENT BOOKINGS =====");

if (bookings.isEmpty()) {
    System.out.println("No bookings found.");
    return;
}


    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
for (Booking booking : bookings) {
    System.out.println(" Booking:");
    System.out.println(" - Room number: " + booking.getRoom().getRoomNumber());
    System.out.println("   Type: " + booking.getRoom().getType());
    System.out.println("   Price/Night: " + booking.getRoom().getPricePerNight() + " MAD");
    System.out.println(" - User ID: " + booking.getUserSnapshot().getUserId());
    System.out.println("   Balance after booking: " + booking.getUserSnapshot().getBalance() + " MAD");
    System.out.println(" - From " + sdf.format(booking.getCheckIn()) + " to " + sdf.format(booking.getCheckOut()));
    System.out.println(" - Total amount: " + booking.getTotalPrice() + " MAD");
    System.out.println("-------------------------------------------------");
}

}


}
