package com.app.dao;

import com.app.pojos.Manager;

public interface IManagerDaoImpl {
	Manager validateManager(Manager m);
	public String registerManager(Manager manager); 
}
