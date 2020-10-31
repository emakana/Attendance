package com.csg.Attendance.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.Attendance.dao.AttendanceDAO;
import com.csg.Attendance.entity.Attendance;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Service
public class AttendanceService {
	@Autowired
	AttendanceDAO repository;

	/**
	 * 
	 * @param list
	 * @return
	 */
	@Transactional
	@SuppressWarnings("unused")
	public List<Attendance> registerDailyAttendance(List<Attendance> list) {

		@SuppressWarnings("unchecked")
		List<Attendance> responseList = (List<Attendance>) repository.saveAll(list);

		return responseList;
	}

	/**
	 * 
	 * @param grade
	 * @param date
	 * @return
	 */
	public List<Attendance> dailyAttendanceByGrade(String grade, Date date) {
		return repository.fetchDailyAttendanceByGrade(grade, date);
	}

	/**
	 * 
	 * @param grade
	 * @param termNo
	 * @return
	 */
	public List<Attendance> termAttendanceByGrade(String grade, String termNo) {
		return repository.fetchTermNoAttendanceByGrade(grade, termNo);
	}

	/**
	 * 
	 * @param studentID
	 * @param day
	 * @return
	 */
	public List<Attendance> dailyAttendanceByStudentID(String studentID, Date day) {
		return repository.fetchDailyAttendanceByStudentID(studentID, day);
	}

	/**
	 * 
	 * @param studentID
	 * @param termNo
	 * @return
	 */
	public List<Attendance> termAttendanceByStudentID(String studentID, String termNo) {
		return repository.fetchTermNoAttendanceByStudentID(studentID, termNo);
	}
}
