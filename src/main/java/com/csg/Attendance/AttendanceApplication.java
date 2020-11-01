package com.csg.Attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Ephraim Makana
 *
 */
@SpringBootApplication
@EntityScan("com.csg.Attendance")
@EnableJpaRepositories("com.csg.Attendance.repository")
public class AttendanceApplication {

	private static final Logger log = LoggerFactory.getLogger(AttendanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

}
