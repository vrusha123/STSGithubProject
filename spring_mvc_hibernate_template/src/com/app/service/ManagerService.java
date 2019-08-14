package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IManagerDaoImpl;
import com.app.pojos.Manager;
@Service
@Transactional
public class ManagerService implements IManagerServiceImpl 
{
    @Autowired
    public IManagerDaoImpl dao;
	
	@Override
	public Manager validateManager(Manager m) 
	{
		return dao.validateManager(m);
	}

	@Override
	public String registerManager(Manager manager) 
	{
		return dao.registerManager(manager);
	}

}
