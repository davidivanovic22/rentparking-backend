package com.example.rentparking.service.impl;

import com.example.rentparking.entity.*;
import com.example.rentparking.repository.ParkingRepository;
import com.example.rentparking.service.ParkingService;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {
	private final ParkingRepository parkingRepository;

	@Override
	public List<Parking> findAll() {
		return parkingRepository.findAll();
	}

	@Override
	public Parking findById(Integer parkingId) {
		return parkingRepository.findById(parkingId)
				.orElseThrow(() -> new NoSuchElementException("ParkingService.notFound"));
	}

	@Override
	public Parking save(Parking parking) {
		return parkingRepository.save(parking);
	}

	@Override
	public Parking update(Parking parking) {
		return parkingRepository.save(parking);
	}

	@Override
	public void deleteById(Integer parkingId) {
		parkingRepository.deleteById(parkingId);
	}


}