package com.fuatkara.map;

import java.io.Serializable;
import java.util.Set;

public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long departmentId;
	
	private String departmentName;
	
	private Set<Employee> employees;
	
	public Department() {
	}

	public Department(String departmentName, Set<Employee> employees) {
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
				+ employees + "]";
	}

}