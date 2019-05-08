package com.jmic.employee.portal.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection="employee")
//@JsonIgnoreProperties(value={"joinDate"}, allowGetters = true)
public class Employee {
	
	private ObjectId _id;
	
	@Id
	private Integer idEmployee;
	
	private String nameEmployee;
	
	private String lastNameEmployee;
	
	private String designation;
	
	private Set<String> projects = new HashSet<String>();
	
	private boolean active;
	
	@JsonIgnoreProperties(value={"joinDate"}, allowGetters = true)
//	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date joinDate = new Date();

	
	public Employee() {
	}

	public Employee(ObjectId _id,Integer idEmployee, String nameEmployee, String lastNameEmployee, String designation, Boolean active,
			Set<String> projects) {
		this.idEmployee = idEmployee;
		this.nameEmployee = nameEmployee;
		this.lastNameEmployee = lastNameEmployee;
		this.active = active;
		this.projects = projects;
	}
	
	public String get_id() { return _id.toHexString(); }
	  public void set_id(ObjectId _id) { this._id = _id; }

	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getLastNameEmployee() {
		return lastNameEmployee;
	}

	public void setLastNameEmployee(String lastNameEmployee) {
		this.lastNameEmployee = lastNameEmployee;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<String> getProjects() {
		return projects;
	}

	public void setProjects(Set<String> projects) {
		this.projects = projects;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", nameEmployee=" + nameEmployee
				+ ", lastNameEmployee=" + lastNameEmployee + ", designation=" + designation +", active=" + active + ", projects=" + projects + "]";
	}
}
