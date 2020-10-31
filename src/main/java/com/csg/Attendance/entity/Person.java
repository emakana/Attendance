package com.csg.Attendance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;



@MappedSuperclass
public abstract class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id = 0L;

	@NotNull
    private String fullName;
	
	@Size(min=9, max = 13, message = "{Size.idNo}")
	@Column(name="id_no")
    private String idNo;
    
    @CreationTimestamp
    private Date createdAt;
    
    public Person() {
    	
    }
    

	public Person(@NotNull String fullName, @Size(min = 9, max = 13, message = "{Size.idNo}") String idNo,
			Date createdAt) {
		super();
		this.fullName = fullName;
		this.idNo = idNo;
		this.createdAt = createdAt;
	}



	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
    

}
