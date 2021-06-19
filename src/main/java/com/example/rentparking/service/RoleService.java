package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import java.util.Collection;
import java.util.List;

public interface RoleService {

	List<Role> findAll();

	Role save(Role role);

	Role update(Role role);

	Role findById(Integer roleId);

	void deleteById(Integer roleId);

	List<User> findAllUsersById(Integer roleId);

	List<User> addUsersById(Integer roleId, List<User> users);

	List<User> setUsersById(Integer roleId, List<User> users);

	List<User> deleteUsersById(Integer roleId, List<User> users);

}