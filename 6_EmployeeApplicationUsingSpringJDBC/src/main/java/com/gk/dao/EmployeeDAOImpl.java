package com.gk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gk.model.Employee;

@Repository(value = "employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	// to connect to the database and execute SQL queries. It internally uses JDBC
	// api.
	@Autowired
	JdbcTemplate jdbcTemp;

	@Override
	public String add(Employee employee) {
		String status = "";
		try {
			Employee emp = search(employee.getEmpId());// Only to check that employee object is null or not.
			if (emp == null) {
				int rowCount = jdbcTemp.update("insert into EMPLOYEE1 values('" + employee.getEmpId() + "','"
						+ employee.getEmpName() + "','" + employee.getEmpAddress() + "')");
				if (rowCount == 1) {
					status = "Success";
				} else {
					status = "Failure";
				}
			} else {
				status = "Existed";
			}

		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(String empId) {
		Employee employee = null;
		List<Employee> list = jdbcTemp.query("Select * from EMPLOYEE1 where EMPID='" + empId + "'",
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee e = new Employee();
						e.setEmpId(rs.getString("empId"));
						e.setEmpName(rs.getString("empName"));
						e.setEmpAddress(rs.getString("empAddress"));
						return e;
					}
				});
		if (list.isEmpty() == true) {
			employee = null;
		} else {
			employee = list.get(0);// beacuse only one employee object we are able to get.
		}
		return employee;
	}

	@Override
	public String update(Employee employee) {

		String status = "";
		int rowCount = jdbcTemp.update("update EMPLOYEE1 set EMPNAME = '" + employee.getEmpName() + "',EMPADDRESS='"
				+ employee.getEmpAddress() + "' where EMPID='" + employee.getEmpId() + "'");
		if (rowCount == 1) {
			status = "Success";
		} else {
			status = "Failure";
		}

		return status;
	}

	@Override
	public String delete(String empId) {

		String status="";
		Employee employee=search(empId);
		if(employee==null) {
			status="NotExisted";
		}
		else {
			int rowCount=jdbcTemp.update("delete from EMPLOYEE1 where EMPID='"+empId+"'");
			if(rowCount==1) {
				status="Success";
			}
			else {
				status="Failure";
			}
		}
		return status;
	}

}
