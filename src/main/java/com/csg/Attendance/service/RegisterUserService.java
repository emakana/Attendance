package com.csg.Attendance.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.Attendance.entity.User;
import com.csg.Attendance.repository.RegisterUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Service
public class RegisterUserService implements Serializable {
	
	private static final Logger log = LoggerFactory.getLogger(RegisterUserService.class);

	private static final long serialVersionUID = 1L;
	
	@Autowired
	RegisterUserRepository repository;
	
	public User saveUser(User user) {
		User dbuser = repository.save(user);
		
		return dbuser;		
	}
	
	public User fetchUserByEmail(String email) {
		User user = repository.findByEmail(email);
		
		return user;	
	}
	
	
}
