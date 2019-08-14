package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeDaoImpl {
	//list of all employee
	List<Employee> findAll();
	//add the employee
	String addEmployee(Employee emp);
	//delete the employee
	String deleteEmployee(int empId);
	//update the detail of employee
	String updateEmployeeDetail(Employee detachedEmployee);

}
