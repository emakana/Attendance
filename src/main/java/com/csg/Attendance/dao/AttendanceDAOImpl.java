package com.csg.Attendance.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csg.Attendance.entity.Attendance;
/**
 * 
 * @author Ephraim Makana
 *
 */
@Component
public class AttendanceDAOImpl implements AttendanceDAO, Serializable {

	private static final long serialVersionUID = 1L;

   @Autowired
   SessionFactory sessionFactory;
  

	@Override
	public List<Attendance> fetchDailyAttendanceByGrade(String grade, Date day) {
		Session session	=sessionFactory.getCurrentSession();
		
		Query query = session.createNativeQuery(
				"select grade, date, studentName, isPresent from Attendance where grade = :grade and date = :day");
		List<Attendance> attendanceList = query.setParameter("grade", grade).setParameter("day", day).getResultList();

		return attendanceList;
	}
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Attendance> fetchTermNoAttendanceByGrade(String grade, String termNo) {
		Session session	=sessionFactory.getCurrentSession();
		
		Query query = session.createNativeQuery(
				"select count(studentId), grade, studentName, isPresent from Attendance where grade = :grade group by studentId having quarter(date) = :termNo");
		List<Attendance> attendanceList = query.setParameter("grade", grade).setParameter("termNo", termNo)
				.getResultList();

		return attendanceList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attendance> fetchDailyAttendanceByStudentID(String studentID, Date day) {
		Session session	= sessionFactory.getCurrentSession();
		
		Query query = session.createNativeQuery(
				"select grade, date, studentName, isPresent from Attendance where studentId = :studentId and date = :day");
		List<Attendance> attendanceList = query.setParameter("studentId", studentID).setParameter("day", day)
				.getResultList();

		return attendanceList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attendance> fetchTermNoAttendanceByStudentID(String studentID, String termNo) {
		Session session	= sessionFactory.getCurrentSession();
		
		Query query = session.createNativeQuery(
				"select count(studentId), grade, studentName, isPresent from Attendance where studentId = :studentID group by studentId having quarter(date) = :termNo");
		List<Attendance> attendanceList = query.setParameter("studentId", studentID).setParameter("termNo", termNo)
				.getResultList();

		return attendanceList;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Attendance arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Attendance> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Attendance> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Attendance> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Attendance> findById(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Attendance> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Attendance> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}