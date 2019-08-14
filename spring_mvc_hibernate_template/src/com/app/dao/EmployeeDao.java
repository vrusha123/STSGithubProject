package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;
@Repository
public class EmployeeDao implements IEmployeeDaoImpl 
{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Employee> findAll() 
	{
		String jpql = "select e from Employee e";
		return sf.getCurrentSession().createQuery(jpql, Employee.class).getResultList();
	}


	@Override
	public String deleteEmployee(int empId)
	{
		Session hs = sf.getCurrentSession();
		Employee emp = hs.get(Employee.class, empId);
		if (emp != null) 
		{
			hs.delete(emp);
			return "Employee with ID " + empId + " deleted";
		} else 
			return "Employee deletion failed";
	}


	@Override
	public String addEmployee(Employee emp) 
	{
		sf.getCurrentSession().save(emp);
		return "Employee added successfully with ID " + emp.getEmpId();
	}


	@Override
	public String updateEmployeeDetail(Employee detachedEmployee) {
		sf.getCurrentSession().saveOrUpdate(detachedEmployee);
		return "Employee details updated";
	}

}
