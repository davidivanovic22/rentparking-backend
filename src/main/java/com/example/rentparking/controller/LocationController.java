package com.example.rentparking.controller;

import com.example.rentparking.entity.*;
import java.util.List;

import com.example.rentparking.service.LocationService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
	private final LocationService locationService;

	@GetMapping
	public ResponseEntity<List<Location>> getAllLocations() {
		return ResponseEntity.ok(locationService.findAll());
	}

	@GetMapping("/{locationId}")
	public ResponseEntity<Location> getLocationById(@PathVariable Integer locationId) {
		return ResponseEntity.ok(locationService.findById(locationId));
	}

	@PostMapping
	public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
		return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(location));
	}

	@PutMapping
	public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
		return ResponseEntity.ok(locationService.update(location));
	}

	@DeleteMapping("/{locationId}")
	public void deleteLocationById(@PathVariable Integer locationId) {
		locationService.deleteById(locationId);
	}

}

