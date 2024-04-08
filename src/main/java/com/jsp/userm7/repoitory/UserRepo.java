package com.jsp.userm7.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userm7.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
