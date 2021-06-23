package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import java.util.Collection;
import java.util.List;

public interface ParkingService {

	List<Parking> findAll();

	List<Parking> findAllByCity(String city);

	Parking save(Parking parking);

	Parking update(Parking parking);

	Parking findById(Integer parkingId);

	void deleteById(Integer parkingId);

}