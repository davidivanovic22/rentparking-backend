package com.example.rentparking.controller;

import com.example.rentparking.entity.*;
import com.example.rentparking.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkings")
@RequiredArgsConstructor
public class ParkingController {
	private final ParkingService parkingService;

	@GetMapping
	public ResponseEntity<List<Parking>> getAllParkings() {
		return ResponseEntity.ok(parkingService.findAll());
	}

	@GetMapping("/{parkingId}")
	public ResponseEntity<Parking> getParkingById(@PathVariable Integer parkingId) {
		return ResponseEntity.ok(parkingService.findById(parkingId));
	}

	@PostMapping
	public ResponseEntity<Parking> saveParking(@RequestBody Parking parking) {
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingService.save(parking));
	}

	@PutMapping
	public ResponseEntity<Parking> updateParking(@RequestBody Parking parking) {
		return ResponseEntity.ok(parkingService.update(parking));
	}

	@DeleteMapping("/{parkingId}")
	public void deleteParkingById(@PathVariable Integer parkingId) {
		parkingService.deleteById(parkingId);
	}

}

