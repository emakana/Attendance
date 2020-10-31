package com.csg.Attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csg.Attendance.entity.User;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Repository
public interface RegisterUserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	
}
