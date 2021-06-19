package com.example.rentparking.service.impl;

import com.example.rentparking.entity.*;
import com.example.rentparking.repository.BookingRepository;
import com.example.rentparking.service.BookingService;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
	private final BookingRepository bookingRepository;

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking findById(Integer bookingId) {
		return bookingRepository.findById(bookingId)
				.orElseThrow(() -> new NoSuchElementException("BookingService.notFound"));
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking update(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void deleteById(Integer bookingId) {
		bookingRepository.deleteById(bookingId);
	}


}