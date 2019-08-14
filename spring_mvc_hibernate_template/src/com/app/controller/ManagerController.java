package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Manager;
import com.app.service.IManagerServiceImpl;

@CrossOrigin(origins = "*",allowedHeaders="*")
@RestController
@RequestMapping("/manager")
public class ManagerController 
{
 @Autowired
 public IManagerServiceImpl service;
 @PostMapping("/login")
	public ResponseEntity<?> processLoginForm(@RequestBody Manager m)

	{
		System.out.println("in login form");
		try
		{
		Manager manager=service.validateManager(m);
		System.out.println(manager.toString());
		return new ResponseEntity<Manager>(manager,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Invalid password",HttpStatus.NOT_FOUND);	
		}
	
	}
	@PostMapping("/register")
	public ResponseEntity<?> registerManager(@RequestBody Manager manager)
	{
		System.out.println("Inside UserController registerArtist()");
		System.out.println(manager);
		service.registerManager(manager);
		return new ResponseEntity<String>("addded Manager successfully",HttpStatus.OK);
	}

}
