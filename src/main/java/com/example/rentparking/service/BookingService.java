package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.BookingStatus;

import java.util.Collection;
import java.util.List;

public interface BookingService {

	List<Booking> findAll();

	Booking save(Booking booking);

	Booking update(Booking booking);

	Booking findById(Integer bookingId);

	void deleteById(Integer bookingId);

	List<Booking> findAllByBookingStatusAndLocationName(BookingStatus bookingStatus, String name);

	List<Booking> findAllByBookingStatusAndLocationCity(BookingStatus bookingStatus, String city);

}