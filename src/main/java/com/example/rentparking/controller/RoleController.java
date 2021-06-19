package com.example.rentparking.controller;

import com.example.rentparking.entity.*;
import com.example.rentparking.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
	private final RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> getAllRoles() {
		return ResponseEntity.ok(roleService.findAll());
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleService.findById(roleId));
	}

	@PostMapping
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
	}

	@PutMapping
	public ResponseEntity<Role> updateRole(@RequestBody Role role) {
		return ResponseEntity.ok(roleService.update(role));
	}

	@DeleteMapping("/{roleId}")
	public void deleteRoleById(@PathVariable Integer roleId) {
		roleService.deleteById(roleId);
	}

	@GetMapping("/{roleId}/users")
	public ResponseEntity<List<User>> getRoleUsers(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleService.findAllUsersById(roleId));
	}

	@PostMapping("/{roleId}/users")
	public ResponseEntity<List<User>> setRoleUsers(@PathVariable Integer roleId, @RequestBody List<User> users) {
		return ResponseEntity.ok(roleService.setUsersById(roleId, users));
	}

	@PutMapping("/{roleId}/users")
	public ResponseEntity<List<User>> addRoleUsers(@PathVariable Integer roleId, @RequestBody List<User> users) {
		return ResponseEntity.ok(roleService.addUsersById(roleId, users));
	}

	@DeleteMapping("/{roleId}/users")
	public ResponseEntity<List<User>> deleteRoleUsers(@PathVariable Integer roleId, @RequestBody List<User> users) {
		return ResponseEntity.ok(roleService.deleteUsersById(roleId, users));
	}

}

