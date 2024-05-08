package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {

		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 *
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */
			// Check if the room is already booked
		if (bookings.containsKey(room)) {
			// If the room is already booked, return false
			return false;
		} else {
			// If the room is not booked, add the guest to the bookings map and return true
			bookings.put(room, guest);
			return true;
		}
	}

	public double totalRevenue() {
		
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */
		return bookings.keySet().stream()
				.mapToDouble(Room::getRate)
				.sum();
	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
