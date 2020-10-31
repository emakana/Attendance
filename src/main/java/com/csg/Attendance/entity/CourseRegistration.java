package com.csg.Attendance.entity;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
class CourseRegistration implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    Long id;
 
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
 
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
 
    private LocalDateTime registeredAt;
 
    private String grade;

	public CourseRegistration(Long id, Student student, Course course, LocalDateTime registeredAt, String grade) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.registeredAt = registeredAt;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}