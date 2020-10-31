package com.csg.Attendance.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.Attendance.entity.User;
import com.csg.Attendance.repository.AuthenticateUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Service
public class AuthenticateUserService implements Serializable {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticateUserService.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	AuthenticateUserRepository authenticateRepository;
	
	public User fetchUserByEmailAndPassword(String email, String password){
		
		User user = authenticateRepository.findUserByEmailAndPassword(email, password);
		
		return user;
	}
}
