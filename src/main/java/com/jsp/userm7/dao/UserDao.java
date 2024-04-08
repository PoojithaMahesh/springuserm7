package com.jsp.userm7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userm7.dto.User;
import com.jsp.userm7.repoitory.UserRepo;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	public User saveUser(User user) {
		return repo.save(user);
	}

}
