package com.books.library.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long empId;
	public String empName;
	
	public Employees(String empName) {
		super();
		this.empName = empName;
	}

	public Employees() {
		super();
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
