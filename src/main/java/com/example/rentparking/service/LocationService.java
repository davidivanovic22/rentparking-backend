package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import java.util.Collection;
import java.util.List;

public interface LocationService {

	List<Location> findAll();

	Location save(Location location);

	Location update(Location location);

	Location findById(Integer locationId);

	void deleteById(Integer locationId);

}