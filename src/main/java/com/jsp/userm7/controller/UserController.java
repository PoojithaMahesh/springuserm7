package com.jsp.userm7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userm7.dao.UserDao;
import com.jsp.userm7.dto.User;

@RestController
public class UserController {
	@Autowired
	private UserDao dao;
     @RequestMapping("/save")
	public User saveUser(@RequestBody User user) {
		return dao.saveUser(user);
	}
}
