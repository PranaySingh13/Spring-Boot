package com.gk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gk.model.Employee;
import com.gk.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
	// ---------------------For Adding Operation------------

	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String showAddPage() {
		return "AddForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam String eid, @RequestParam String ename, @RequestParam String eaddr, ModelMap map) {
		map.addAttribute("operation", "Employee Insertion");
		Employee employee = new Employee();
		employee.setEmpId(eid);
		employee.setEmpName(ename);
		employee.setEmpAddress(eaddr);

		String status = employeeService.addEmployee(employee);
		return status;
	}

	// ---------------------For Searching Operation------------

	@RequestMapping(value = "/searchForm", method = RequestMethod.GET)
	public String showSearchPage() {
		return "SearchForm";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam String eid, ModelMap map) {

		String status = "";
		Employee employee = employeeService.searchEmployee(eid);
		if (employee == null) {
			status = "NotExisted";
		} else {
			map.addAttribute("emp", employee);
			status = "EmployeeDetails";
		}
		return status;
	}

	// ----------------------For Editing and Updating Operation------------

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String showUpdatePage() {
		return "UpdateForm";
	}

	@RequestMapping(value = "/editform", method = RequestMethod.GET)
	public String showEditPage() {
		return "EditForm";
	}

	@RequestMapping(value = "/editform",method = RequestMethod.POST)
	public String edit(@RequestParam String eid, ModelMap map) {
		String status = "";
		Employee employee = employeeService.searchEmployee(eid);
		if (employee == null) {
			status = "NotExisted";
		} else {
			map.addAttribute("emp", employee);
			status = "EditForm";
		}
		return status;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam String eid, @RequestParam String ename, @RequestParam String eaddr,
			ModelMap map) {
		String status = "";
		map.addAttribute("operation", "Employee Updation");
		Employee employee = new Employee();
		employee.setEmpId(eid);
		employee.setEmpName(ename);
		employee.setEmpAddress(eaddr);

		status = employeeService.updateEmployee(employee);
		return status;
	}

	// ----------------------For Deleting Operation------------

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String showDeletePage() {
		return "DeleteForm";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String eid, ModelMap map) {
		map.addAttribute("operation", "Employee Deletion");
		String status = employeeService.deleteEmployee(eid);
		return status;
	}
}
