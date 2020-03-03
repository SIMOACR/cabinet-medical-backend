package com.cabinet.cabinetmedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.cabinetmedical.entity.User;
import com.cabinet.cabinetmedical.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value="/adduser")
	public User addUser( @RequestBody User user ) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		userService.addUser(user);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/user/{id}")
	public User getUserById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return userService.getUser(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/updateuser")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getpatients")
	public List<User> getPatients() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return userService.getPatients();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/userByRdvId/{idrdv}")
	public User userByRdvId(@PathVariable Long idrdv) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "200");
		headers.add("message", "OK");
		return userService.getUserByRdvId(idrdv);
	}

}
