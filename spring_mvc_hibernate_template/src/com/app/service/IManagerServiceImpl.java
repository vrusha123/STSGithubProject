package com.app.service;

import com.app.pojos.Manager;

public interface IManagerServiceImpl {
	Manager validateManager(Manager m);
	public String registerManager(Manager manager); 

}
