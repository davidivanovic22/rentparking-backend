package com.example.rentparking.service.impl;

import com.example.rentparking.entity.*;
import com.example.rentparking.repository.RoleRepository;
import com.example.rentparking.service.RoleService;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Integer roleId) {
		return roleRepository.findById(roleId)
				.orElseThrow(() -> new NoSuchElementException("RoleService.notFound"));
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role update(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteById(Integer roleId) {
		roleRepository.deleteById(roleId);
	}

	@Override
	public List<User> findAllUsersById(Integer roleId) {
		return findById(roleId).getUsers();
	}

	@Override
	public List<User> addUsersById(Integer roleId, List<User> users) {
		Role role = findById(roleId);
		role.getUsers().addAll(users);
		return roleRepository.save(role).getUsers();
	}

	@Override
	public List<User> setUsersById(Integer roleId, List<User> users) {
		Role role = findById(roleId);
		role.setUsers(users);
		return roleRepository.save(role).getUsers();
	}

	@Override
	public List<User> deleteUsersById(Integer roleId, List<User> users) {
		Role role = findById(roleId);
		role.getUsers().removeAll(users);
		return roleRepository.save(role).getUsers();
	}


}