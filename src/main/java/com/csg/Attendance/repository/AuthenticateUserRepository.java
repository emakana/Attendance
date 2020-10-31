package com.csg.Attendance.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;  

import org.springframework.stereotype.Repository;

import com.csg.Attendance.entity.User;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Repository
public interface AuthenticateUserRepository extends CrudRepository<User, Long> {
     User findUserByEmailAndPassword(String email, String Password);
}
