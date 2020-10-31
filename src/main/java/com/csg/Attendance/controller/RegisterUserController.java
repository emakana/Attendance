package com.csg.Attendance.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csg.Attendance.entity.User;
import com.csg.Attendance.service.RegisterUserService;

import lombok.RequiredArgsConstructor;
/**
 * 
 * @author Ephraim Makana
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RegisterUserController implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	RegisterUserService registerService;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws RegistrationException
	 */
	@PostMapping(path = "/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@Valid @RequestBody User user) throws RegistrationException {
		User tempUser = registerService.fetchUserByEmail(user.getEmail());

		if (tempUser != null) {
			throw new RegistrationException("user with email id :" + user.getEmail() + " already exist");
		} else {
			tempUser = registerService.saveUser(user);
		}

		return tempUser;
	}

}
