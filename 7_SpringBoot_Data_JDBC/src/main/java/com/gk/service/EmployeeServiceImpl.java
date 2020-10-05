package com.gk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.EmployeeDAO;
import com.gk.model.Employee;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Transactional // The transactional annotation itself defines the scope of a single database
					// transaction.
	@Override
	public String addEmployee(Employee employee) {
		String status = "";
		try {
			/*
			 * To save the employee, isNew value is true.
			 */
			Employee.isNew = true;
			Employee emp = employeeDao.save(employee);
			if (emp.getEmpId().equals(employee.getEmpId())) {
				status = "Success";
			} else {
				status = "Failure";
			}

		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	/*
	 * @Transactional is not required for search operation as it only retrieve data
	 * from db, it is not changing any value or updation in database.
	 */
	@Override
	public Employee searchEmployee(String empId) {
		Employee employee = null;
		try {
			// crud repository method
			Optional<Employee> opt = employeeDao.findById(empId);
			
			//To handle Null Pointer Exception in Optional data type for when getting null value of object.
			if(opt.isPresent()) {
				employee = opt.get();	
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Transactional
	@Override
	public String updateEmployee(Employee employee) {
		String status = "";
		try {
			// i.e; now save method is for update operation
			Employee.isNew = false;
			// crud repository method(this time it will update the database table)
			Employee emp = employeeDao.save(employee);
			if (emp.getEmpId().equals(employee.getEmpId())) {
				status = "Success";
			} else {
				status = "Failure";
			}
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Transactional
	@Override
	public String deleteEmployee(String empId) {
		String status = "";
		try {
			employeeDao.deleteById(empId);
			status = "Success";
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

}
