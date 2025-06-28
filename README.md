
# Description du projet :

This project is a simplified implementation of a hotel reservation system developed in Java, as part of the Skypay Technical Test 2.

It allows to:

Create hotel rooms with a number, type, and price per night.

Create users with an ID and an initial balance.

Book rooms for a given period if the user has sufficient balance and the room is available.

Display all rooms and bookings (from latest to oldest).

Display all users (from latest to oldest).

# Result de printAll() et printAllUsers() :

![image](https://github.com/user-attachments/assets/c7c4f7ed-6fc0-4db8-b883-dac9be65b0f8)

<img width="297" alt="image" src="https://github.com/user-attachments/assets/2fdbb432-3e9f-4713-90f4-89b994023b78" />


# Bonus Questions :
## 1/ Suppose we put all the functions inside the same service. Is this the recommended approach ? Please explain.
-No, putting all functions inside the same service is not recommended. It violates the Single Responsibility Principle, which states that a class or service should have only one reason to change. Separating functions into dedicated services (e.g., RoomService, UserService, BookingService) improves code maintainability, readability, and testability. It also allows each service to focus on a specific domain, making the system easier to scale and modify.

## 2/- In this design, we chose to have a function setRoom(..) that should not impact the previous bookings. What is another way ? What is your
## recommendation ? Please explain and justify.
-In this design, setRoom() does not impact previous bookings to preserve historical accuracy and data integrity. Another way to handle this would be to implement versioning for rooms each update to a room would create a new version, while existing bookings would reference the room version at booking time. This approach maintains immutability of past bookings while allowing room updates.
However, my recommendation is to use snapshots within the booking itself (storing room details like type and price at booking time). This method is simpler, reduces complexity, and ensures bookings remain consistent regardless of later changes to rooms. It also facilitates straightforward auditing and reporting, making it a best practice for systems requiring reliable historical data.
