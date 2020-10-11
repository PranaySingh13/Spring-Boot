package com.gk.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gk.dao.UserDao;
import com.gk.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/*
	 * @PostConstruct annotation will make a method to execute by the IOC Container
	 * while performing Beans iniitalization.So therefore here IT will persist the
	 * data in the database in the background.
	 */
	@PostConstruct
	public void initDatabase() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "Ms Dhoni", "Captain", 39));
		users.add(new User(2, "Virat Kohli", "Batsman", 31));
		users.add(new User(3, "Rohit Sharma", "Batsman", 33));
		users.add(new User(4, "Shikhar Dhawan", "Batsman", 33));
		users.add(new User(5, "JBumraah", "Bowler", 27));
		users.add(new User(6, "YChahal", "Bowler", 24));
		users.add(new User(7, "RAshwin", "Bowler", 24));
		users.add(new User(8, "Sir R.Jadeja", "All Rounder", 30));
		users.add(new User(9, "Hardik Pandya", "All Rounder", 26));
		users.add(new User(10, "KLRahul", "WicketKeeper", 28));
		users.add(new User(11, "DKarthik", "WicketKeeper", 39));
		userDao.saveAll(users);
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public List<User> getUserByProfession(String profession) {
		return userDao.findByProfession(profession);
	}

	@Override
	public long getCounts(int age) {
		return userDao.countByAge(age);
	}

	@Override
	public List<User> deleteUser(String name) {
		return userDao.deleteByName(name);
	}

	@Override
	public List<User> findByMulticondition(String profession, int age) {
		return userDao.findByProfessionAndAge(profession, age);
	}

	@Override
	public List<User> getUserIgnoreCase(String profession) {
		return userDao.findByProfessionIgnoreCase(profession);
	}

	//Sorting in Data JPA
	@Override
	public List<User> getUserSort(String field) {
		return userDao.findAll(Sort.by(Direction.ASC, field));
	}
	
	//Pagination(Dividing a document into discrete pages from given index range) in Data JPA
	@Override
	public Page<User> getPaginatedUser(){
		return userDao.findAll(PageRequest.of(0,5));
	}

	//Custom Query
	@Override
	public List<User> getUsersCustomQuery() {
		return userDao.getCustomQuery();
	}

}
