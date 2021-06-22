package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.domen.BookingStatus;
import com.example.rentparking.entity.data.dto.BookingDTO;

import java.util.List;

public interface BookingService {

	List<Booking> findAll();

	Booking save(Booking booking);

	Booking update(Booking booking);

	Booking findById(Integer bookingId);

	void deleteById(Integer bookingId);

	List<Booking> findAllByBookingStatusAndLocationName(BookingStatus bookingStatus, String name);

	List<Booking> findAllByBookingStatusAndLocationCity(BookingStatus bookingStatus, String city);

List<BookingDTO> findAllBookingDTOByCity(String city);

}