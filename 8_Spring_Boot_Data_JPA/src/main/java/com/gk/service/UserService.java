package com.gk.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gk.model.User;

public interface UserService {
/*
 * At Service and Controller layer method and argument parameter can be different.
 */
	public List<User> getUsers();
	
	public List<User> getUserByProfession(String profession);
	
	public long getCounts(int age);
	
	public List<User> deleteUser(String name);
		
	public List<User> findByMulticondition(String profession, int age);
		
	public List<User> getUserIgnoreCase(String profession);
	
	public List<User> getUserSort(String field);
	
	public Page<User> getPaginatedUser();
	
	public List<User> getUsersCustomQuery();
}
