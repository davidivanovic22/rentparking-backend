package com.example.rentparking.controller;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.dto.SocialUser;
import com.example.rentparking.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findById(userId));
	}

//	@PostMapping("/socialUser")
//	public ResponseEntity<User> saveSocialUser(@RequestBody SocialUser socialUser) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveSocialUser(socialUser));
//	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.update(user));
	}

	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable Integer userId) {
		userService.deleteById(userId);
	}

	@GetMapping("/{userId}/roles")
	public ResponseEntity<List<Role>> getUserRoles(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findAllRolesById(userId));
	}

	@PostMapping("/{userId}/roles")
	public ResponseEntity<List<Role>> setUserRoles(@PathVariable Integer userId, @RequestBody List<Role> roles) {
		return ResponseEntity.ok(userService.setRolesById(userId, roles));
	}

	@PutMapping("/{userId}/roles")
	public ResponseEntity<List<Role>> addUserRoles(@PathVariable Integer userId, @RequestBody List<Role> roles) {
		return ResponseEntity.ok(userService.addRolesById(userId, roles));
	}

	@DeleteMapping("/{userId}/roles")
	public ResponseEntity<List<Role>> deleteUserRoles(@PathVariable Integer userId, @RequestBody List<Role> roles) {
		return ResponseEntity.ok(userService.deleteRolesById(userId, roles));
	}

	@GetMapping("/logged-in")
	public ResponseEntity<User> loggedIn(@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(user);
	}
}

