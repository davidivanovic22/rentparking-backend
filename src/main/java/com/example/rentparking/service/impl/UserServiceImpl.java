package com.example.rentparking.service.impl;

import com.example.rentparking.entity.*;
import com.example.rentparking.repository.UserRepository;
import com.example.rentparking.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public List<Role> findAllRolesById(Integer userId) {
		return findById(userId).getRoles();
	}

	@Override
	public List<Role> addRolesById(Integer userId, List<Role> roles) {
		User user = findById(userId);
		user.getRoles().addAll(roles);
		return userRepository.save(user).getRoles();
	}

	@Override
	public List<Role> setRolesById(Integer userId, List<Role> roles) {
		User user = findById(userId);
		user.setRoles(roles);
		return userRepository.save(user).getRoles();
	}

	@Override
	public List<Role> deleteRolesById(Integer userId, List<Role> roles) {
		User user = findById(userId);
		user.getRoles().removeAll(roles);
		return userRepository.save(user).getRoles();
	}


}