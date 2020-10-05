package com.gk.service;

import com.gk.model.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	
	public Employee searchEmployee(String empId);
	
	public String updateEmployee(Employee employee);
	
	public String deleteEmployee(String empId);
	
}
