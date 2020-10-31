package com.csg.Attendance.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends Person {

	private static final long serialVersionUID = 1L;
	
    @Column(name = "student_id")
    private Long studentId = 0L;
	
	@OneToMany(mappedBy = "student")
    Set<CourseRegistration> registrations;
	 
    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(Long studentId, Set<CourseRegistration> registrations) {
		super();
		this.studentId = studentId;
		this.registrations = registrations;
	}


	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Set<CourseRegistration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<CourseRegistration> registrations) {
		this.registrations = registrations;
	}
 
    
}
