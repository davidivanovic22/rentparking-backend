package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.domen.BookingStatus;
import com.example.rentparking.entity.data.dto.BookingDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<Booking> findAll();

    Booking save(Booking booking);

    void automaticChangeBookingStatus();

    Booking update(Booking booking);

    Booking findById(Integer bookingId);

    List<Booking> findAllByUserId(Integer userId);

    void deleteById(Integer bookingId);

    List<Booking> findAllByBookingStatusAndLocationName(BookingStatus bookingStatus, String name);

    List<Booking> findAllByBookingStatusAndLocationCity(BookingStatus bookingStatus, String city);

    List<BookingDTO> findAllBookingDTO(String city, LocalDateTime from, LocalDateTime to);

   // List<BookingDTO> findAllBookingDTOByCityAndFromAndTo(String city, LocalDateTime from, LocalDateTime to);

}