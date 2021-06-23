package com.example.rentparking.controller;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.domen.BookingStatus;
import com.example.rentparking.entity.data.dto.BookingDTO;
import com.example.rentparking.repository.views.BookingDTOView;
import com.example.rentparking.service.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping("/{userId}/user")
    public ResponseEntity<List<Booking>> getAllByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(bookingService.findAllByUserId(userId));
    }

    @GetMapping("/{bookingStatus}/{city}/booking_status_and_location_city")
    public ResponseEntity<List<Booking>> getAllByBookingStatusAndLocationCity(@PathVariable BookingStatus bookingStatus, @PathVariable String city) {
        return ResponseEntity.ok(bookingService.findAllByBookingStatusAndLocationCity(bookingStatus, city));
    }

    @GetMapping("/{city}/booking_dto")
    public ResponseEntity<List<BookingDTO>> findAllBookingDTO(@PathVariable String city,
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                              @RequestParam(name = "from", required = false) LocalDateTime from,
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                              @RequestParam(name = "to", required = false) LocalDateTime to) {
        return ResponseEntity.ok(bookingService.findAllBookingDTO(city, from, to));
    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(booking));
    }

    @PutMapping
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.update(booking));
    }

    @PutMapping("/automatic_change_booking_status")
    public void automaticChangeBookingStatus() {
        bookingService.automaticChangeBookingStatus();
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBookingById(@PathVariable Integer bookingId) {
        bookingService.deleteById(bookingId);
    }

}

