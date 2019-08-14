package com.app.dao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Manager;
@Repository
public class ManagerDao implements IManagerDaoImpl 
{


	

	@Autowired
	private SessionFactory sf;

	@Override
	public Manager validateManager(Manager m) {
		System.out.println(m.toString());
		System.out.println("email"+m.getEmail());
		System.out.println("password"+m.getPassword());
		String jpql = "select a from Manager a where a.email=:em and a.password=:pa";
		System.out.println(m.toString());
		return sf.getCurrentSession().createQuery(jpql, Manager.class).setParameter("em",m.getEmail()).setParameter("pa", m.getEmail()).getSingleResult();
	}



	@Override
	public String registerManager(Manager manager) {
		sf.getCurrentSession().persist(manager);
		return "Manager registration successful with ID" + manager.getManagerId();
	}
	

}
