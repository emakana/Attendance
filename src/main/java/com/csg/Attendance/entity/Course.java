package com.csg.Attendance.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
    private Long courseId = 0L;
	
	@Column(name = "course_desc")
	private String courseDesc = null;
 
    @OneToMany(mappedBy = "course")
    Set<CourseRegistration> registrations;
    

	public Course(Long courseId, Set<CourseRegistration> registrations) {
		super();
		this.courseId = courseId;
		this.registrations = registrations;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Set<CourseRegistration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<CourseRegistration> registrations) {
		this.registrations = registrations;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	
	
 
    
}
