package com.example.rentparking.controller;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.BookingStatus;
import com.example.rentparking.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
	private final BookingService bookingService;

	@GetMapping
	public ResponseEntity<List<Booking>> getAllBookings() {
		return ResponseEntity.ok(bookingService.findAll());
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Integer bookingId) {
		return ResponseEntity.ok(bookingService.findById(bookingId));
	}

	@GetMapping("/{bookingStatus}/{city}/booking_status_and_location_city")
	public ResponseEntity<List<Booking>> getAllByBookingStatusAndLocationCity(@PathVariable BookingStatus bookingStatus, @PathVariable String city) {
		return ResponseEntity.ok(bookingService.findAllByBookingStatusAndLocationCity(bookingStatus, city));
	}

	@PostMapping
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(booking));
	}

	@PutMapping
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
		return ResponseEntity.ok(bookingService.update(booking));
	}

	@DeleteMapping("/{bookingId}")
	public void deleteBookingById(@PathVariable Integer bookingId) {
		bookingService.deleteById(bookingId);
	}

}

