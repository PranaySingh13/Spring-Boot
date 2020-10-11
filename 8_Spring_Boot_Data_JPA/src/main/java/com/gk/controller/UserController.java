package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gk.model.User;
import com.gk.service.UserService;

@RestController
@RequestMapping(value = "/spring-data-jpa")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/getUsers")
	public List<User> getAllUsers() {

		return userService.getUsers();
	}

	@GetMapping(value = "/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable(value = "profession") String profession) {
		return userService.getUserByProfession(profession);
	}

	@GetMapping(value = "/getUserCount/{age}")
	public String getCountAge(@PathVariable int age) {
		long count = userService.getCounts(age);
		return "Total no. of records are: " + count;
	}

	@Transactional
	@DeleteMapping(value = "/delete/{name}")
	public List<User> deleteUser(@PathVariable(value = "name") String name) {
		return userService.deleteUser(name);
	}
	
	@GetMapping(value = "/findMulticondition/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession,@PathVariable int age){
		return userService.findByMulticondition(profession, age);
	}
	
	@GetMapping(value = "/getUserIgnoreCase")
	public List<User> getUserIgnoreCase(@RequestParam(value = "profession") String profession){
		return userService.getUserIgnoreCase(profession);
	}
	
	@GetMapping(value = "/getSort/{field}")
	public List<User> getSortedUsers(@PathVariable String field){
		return userService.getUserSort(field);
	}
	
	@GetMapping(value = "/getPaginatedData")
	public Page<User> getPaginatedRecords(){
		return userService.getPaginatedUser();
	}
	
	@GetMapping(value = "/getRecordsByCustomQuery")
	public List<User> getUserByCustomQuery(){
		return userService.getUsersCustomQuery();
	}
}
