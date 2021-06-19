package com.example.rentparking.service.impl;

import com.example.rentparking.entity.*;
import com.example.rentparking.repository.LocationRepository;
import com.example.rentparking.service.LocationService;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
	private final LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Location findById(Integer locationId) {
		return locationRepository.findById(locationId)
				.orElseThrow(() -> new NoSuchElementException("LocationService.notFound"));
	}

	@Override
	public Location save(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location update(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteById(Integer locationId) {
		locationRepository.deleteById(locationId);
	}


}