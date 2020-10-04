package com.gk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.EmployeeDAO;
import com.gk.model.Employee;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public String addEmployee(Employee employee) {

		String status=employeeDao.add(employee);
		return status;
	}

	@Override
	public Employee searchEmployee(String empId) {
		Employee employee=employeeDao.search(empId);
		return employee;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String status=employeeDao.update(employee);
		return status;
	}

	@Override
	public String deleteEmployee(String empId) {
		String status=employeeDao.delete(empId);
		return status;
	}

}
