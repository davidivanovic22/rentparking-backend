package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import java.util.Collection;
import java.util.List;

public interface BookingService {

	List<Booking> findAll();

	Booking save(Booking booking);

	Booking update(Booking booking);

	Booking findById(Integer bookingId);

	void deleteById(Integer bookingId);

}