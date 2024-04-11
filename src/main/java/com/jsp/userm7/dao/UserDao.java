package com.jsp.userm7.dao;

import java.util.Optional;

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
	public User findUser(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			if something is present inside the optional 
//			id is present
			User user=optional.get();
			return user;
		}else {
//			nothing is presnt inside that optional
//			id is not present
			return null;
		}
		
	}
	public User deleteUser(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			User user=optional.get();
//			 repo.delete(user);
			 repo.deleteById(id);
			 return user;
		}
		return null;
	}
	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

}
