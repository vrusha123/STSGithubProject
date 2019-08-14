package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDaoImpl;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmployeeService implements IEmployeeServiceImpl 
{
	@Autowired
	private IEmployeeDaoImpl dao;
	@Override
	public List<Employee> findAll() 
	{
		
		return dao.findAll();
	}

	@Override
	public String addEmployee(Employee emp) 
	{
		return dao.addEmployee(emp);
	}

	@Override
	public String deleteEmployee(int empId) 
	{
		return dao.deleteEmployee(empId);
	}

	@Override
	public String updateEmployeeDetail(Employee detachedEmployee) {
		return dao.updateEmployeeDetail(detachedEmployee);
	}

}
