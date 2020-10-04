package com.gk.dao;

import com.gk.model.Employee;

public interface EmployeeDAO {

	public String add(Employee employee);
	
	public Employee search(String empId);
	
	public String update(Employee employee);
	
	public String delete(String empId);
}
