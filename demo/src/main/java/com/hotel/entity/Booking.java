package com.hotel.entity;

import java.util.Date;

public class Booking {

    private final Room roomSnapshot;
    private final User userSnapshot;
    private final Date checkIn;
    private final Date checkOut;
    private final int totalPrice;

    public Booking( User user,Room room, Date checkIn, Date checkOut, int totalPrice) {
        this.roomSnapshot = new Room(room.getRoomNumber(), room.getType(), room.getPricePerNight());
        this.userSnapshot = new User(user.getUserId(), user.getBalance());
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }



    public Room getRoom() {
        return roomSnapshot;
    }

    public User getUserSnapshot() {
        return userSnapshot;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + roomSnapshot +
                ", user=" + userSnapshot +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public boolean isOverlapping(Date start, Date end) {
        return !(checkOut.before(start) || checkIn.after(end));
    }
}
