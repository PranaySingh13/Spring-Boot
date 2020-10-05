package com.gk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

/*
 * We making this Dto class implemented by persistable
 * because to save or update an employee from single save
 * method of crud repository.
 */
public class Employee implements Persistable<String> {

	// for getting dyanamic value for this value initialize it with false.
	public static boolean isNew = false;

	@Id
	private String empId;
	private String empName;
	private String empAddress;

	@Override
	public String getId() {

		return empId;
	}

	/*
	 * Based on its return value either employee save or update operation will be
	 * performed.
	 * 
	 */
	@Override
	public boolean isNew() {

		return isNew;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

}
