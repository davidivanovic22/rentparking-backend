package com.example.rentparking.controller;


import com.example.rentparking.entity.Booking;
import com.example.rentparking.entity.User;
import com.example.rentparking.exception.http.HttpUnauthorizedException;
import com.example.rentparking.service.BookingService;
import com.example.rentparking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logged-in-user")
@RequiredArgsConstructor
public class LoggedInUserController {
private final BookingService bookingService;
private final UserService userService;


    @GetMapping
    public ResponseEntity<User> getLoggedInUser(@AuthenticationPrincipal User user) {
        if (user == null) throw new HttpUnauthorizedException();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookingForLoggedInUser(@AuthenticationPrincipal User user) {
        if (user == null) throw new HttpUnauthorizedException();
        return ResponseEntity.ok(bookingService.findAllByUserId(user.getId()));
    }
}
