package com.csg.Attendance;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AttendanceApplicationTests {
	
	@Autowired
	@Qualifier(value = "entityManager")
	EntityManager manager;

	@Test
	void contextLoads() {
	}

}
