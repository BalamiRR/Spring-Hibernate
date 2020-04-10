package com.fuatkara.map;

import java.io.Serializable;

public class StudentInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer studentId;
	private String adres;
	private String mail;
	private Student student;
	
	public StudentInfo() {
		super();
	}

	public StudentInfo(Integer studentId, String adres, String mail, Student student) {
		super();
		this.studentId = studentId;
		this.adres = adres;
		this.mail = mail;
		this.student = student;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	 
}