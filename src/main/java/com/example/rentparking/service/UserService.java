package com.example.rentparking.service;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.dto.SocialUser;

import java.util.Collection;
import java.util.List;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User saveSocialUser(SocialUser socialUser);

	User update(User user);

	User findById(Integer userId);

	User findByUsername(String username);

	void deleteById(Integer userId);

	List<Role> findAllRolesById(Integer userId);

	List<Role> addRolesById(Integer userId, List<Role> roles);

	List<Role> setRolesById(Integer userId, List<Role> roles);

	List<Role> deleteRolesById(Integer userId, List<Role> roles);

}