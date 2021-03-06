package com.rajwork.BootMVCDB.model;
//import java.sql.Date;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name = "tbl_employee_boot")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	@Size(min = 3)
	private String name;
	@Column
	private String gender;
	@Column
	private String department;
	@Column
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  dob;
	public Employee() {
		
	}
	public Employee(Integer id, String name, String gender, String department, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.dob = dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", dob="
				+ dob + "]";
	}
	
}