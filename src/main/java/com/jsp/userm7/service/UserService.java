package com.jsp.userm7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userm7.dao.UserDao;
import com.jsp.userm7.dto.User;
import com.jsp.userm7.exception.UserIdNotFoundException;
import com.jsp.userm7.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
//this layer is responsible for writing a business logic 
//	it will collect the data to be saved from the controller
//	it will pass that data to the dao
//	it will take the saved data from the dao
//	it will return reponseStructure of user to the controller
	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser=dao.findUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			throw new UserIdNotFoundException("Sorry Failed to fetch the data");
		}
		
	}
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser=dao.deleteUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data Deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			throw new UserIdNotFoundException("Sorry Failed to delete the data");
		}
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id, user);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}else {
			throw new UserIdNotFoundException("Sorry Failed to Update the data");
		}
	}
}
