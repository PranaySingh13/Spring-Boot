package com.gk.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.model.Employee;

@Repository
/*
 * CrudRepository<Entity Name,Data type of Primary key of Entity>
 */
public interface EmployeeDAO extends CrudRepository<Employee, String> {

	/*
	 * All the basic crud operation are present in the CrudRepository interface like
	 * save,delete,update,findAll and many more...
	 */

}
