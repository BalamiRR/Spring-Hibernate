package com.fuatkara.map;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer studentId;
	
	private String studentName;
	private String studentSurname;
	private StudentInfo studentInfo;

	public Student() {
		super();
	}
	
	public Student(int studentId, String studentName, String studentSurname, StudentInfo studentInfo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentInfo = studentInfo;
	}

	public Student(String studentName, String studentSurname) {
		super();
		this.studentName = studentName;
		this.studentSurname = studentSurname;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
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

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	@Override
	public String toString() {
		return "Ogrenci [studentId=" + studentId + ", studentName=" + studentName + ", studentSurname=" + studentSurname
				+ ", studentInfo=" + studentInfo + "]";
	}
}