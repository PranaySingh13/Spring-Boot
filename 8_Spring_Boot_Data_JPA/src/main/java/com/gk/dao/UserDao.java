package com.gk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gk.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	// Custom Methods using JPA Repository Standards.
	
	/*
	 * 1. Parameter name in argument should be same as the variable declared in pojo.
	 * 
	 * 2. Method name syntax should be same as of ex. findById(int id) method then only,
	 * spring-data-jpa will convert the method into query string otherwise it will
	 * throw runtime exceptions if the method or arguments name is not same.
	 */
	public List<User> findByProfession(String profession);

	public long countByAge(int age);

	public List<User> deleteByName(String name);

	//Multiple Argument Condition
	public List<User> findByProfessionAndAge(String profession, int age);
	
	//Case Insensitive Condition
	public List<User> findByProfessionIgnoreCase(String profession);
	
	//Custom Query
	
	//@Modifying //For Update and Delete Custom query it tell container that this method will change the state in the database. 
	
	@Query(value = "SELECT * FROM USER u WHERE u.age<30",nativeQuery = true)
	public List<User> getCustomQuery();
}
