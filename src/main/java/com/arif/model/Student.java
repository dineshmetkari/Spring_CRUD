package com.arif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column
	private String studentName;
	
	@Column
	private String studentSurname;
	
	@Column
	private String studentDepartment;
	
	@Column
	private String studentAddress;

	// Destructor of Student
	public Student() {
	}
	

	// Constructor of Student

	public Student(int studentId, String studentName, String studentSurname,
			String studentDepartment, String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentDepartment = studentDepartment;
		this.studentAddress = studentAddress;
	}



	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

}
