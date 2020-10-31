package com.csg.Attendance.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csg.Attendance.entity.User;
import com.csg.Attendance.service.AuthenticateUserService;

import lombok.RequiredArgsConstructor;
/**
 * 
 * @author Ephraim Makana
 *
 */
@RestController
@RequiredArgsConstructor
public class AuthenticateUserController implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(AuthenticateUserController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	AuthenticateUserService authenticateService;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws AuthenticateUserException
	 */
	@PostMapping(path = "/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User authenticateUser(@RequestBody User user) throws AuthenticateUserException {
		String email = user.getEmail();
		String password = user.getPassword();

		User dbUser = null;

		if ((email != null || !email.equals("")) && (password != null || !password.equals(""))) {
			dbUser = authenticateService.fetchUserByEmailAndPassword(email, password);
			if (dbUser == null) {
				throw new AuthenticateUserException("Incorrect username or password");
			}
		}

		return dbUser;
	}
}
