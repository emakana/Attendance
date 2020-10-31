package com.csg.Attendance.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csg.Attendance.entity.Attendance;
import com.csg.Attendance.service.AttendanceService;

import lombok.RequiredArgsConstructor;
/**
 * 
 * @author Ephraim Makana
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AttendanceController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	AttendanceService service;

	private static final Logger log = LoggerFactory.getLogger(AttendanceController.class);
	/**
	 * 
	 * @param list
	 * @return
	 * @throws AttendanceException
	 */
	@PostMapping(path = "/registerattendance")
	@ResponseBody
	public List<Attendance> registerDailyClassAttendance(@RequestBody List<Attendance> list)
			throws AttendanceException {

		List<Attendance> attendList = null;

		if (list != null && list.size() > 0) {
			attendList = service.registerDailyAttendance(list);
		} else {
			throw new AttendanceException("Try to capture the attendance list");
		}

		return attendList;
	}
	/**
	 * 
	 * @param grade
	 * @param date
	 * @return
	 * @throws AttendanceException
	 */
	@PostMapping(path = "/dailyattendancebygrade")
	@ResponseBody
	public List<Attendance> retrieveDailyAttendanceByGrade(@RequestBody String grade, Date date)
			throws AttendanceException {
		if (date.after(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))) {
			throw new AttendanceException("Attendance is not record yet for a future date");
		}

		return service.dailyAttendanceByGrade(grade, date);
	}
	/**
	 * 
	 * @param grade
	 * @param termNo
	 * @return
	 */
	@PostMapping(path = "/termattendancebygrade")
	@ResponseBody
	public List<Attendance> retrieveTermAttendanceByGrade(@RequestBody String grade, String termNo) {
		return service.termAttendanceByGrade(grade, termNo);
	}
	/**
	 * 
	 * @param grade
	 * @param date
	 * @return
	 * @throws AttendanceException
	 */
	@PostMapping(path = "/dailyattendancebystudentid")
	@ResponseBody
	public List<Attendance> retrieveDailyAttendanceByStudentId(String grade, Date date) throws AttendanceException {

		if (date.after(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))) {
			throw new AttendanceException("Attendance is not record yet for a future date");
		}

		return service.dailyAttendanceByStudentID(grade, date);
	}
	/**
	 * 
	 * @param studentID
	 * @param termNo
	 * @return
	 */
	@PostMapping(path = "/termattendancebystudentid")
	@ResponseBody
	public List<Attendance> retrieveTermAttendanceByStudentID(String studentID, String termNo) {

		return service.termAttendanceByStudentID(studentID, termNo);
	}

}
