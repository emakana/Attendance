package com.csg.Attendance.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.csg.Attendance.entity.Attendance;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Repository
public interface AttendanceDAO {

	List<Attendance> fetchDailyAttendanceByGrade(String grade, Date day);

	List<Attendance> fetchTermNoAttendanceByGrade(String grade, String termNo);

	List<Attendance> fetchDailyAttendanceByStudentID(String studentID, Date day);

	List<Attendance> fetchTermNoAttendanceByStudentID(String studentID, String termNo);

}
