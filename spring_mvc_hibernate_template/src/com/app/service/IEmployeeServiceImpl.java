package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeServiceImpl
{
	List<Employee> findAll();
	String addEmployee(Employee emp);
	String deleteEmployee(int empId);
	String updateEmployeeDetail(Employee detachedEmployee);
}
