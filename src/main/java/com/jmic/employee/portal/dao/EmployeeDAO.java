package com.jmic.employee.portal.dao;

import java.util.Set;

import com.jmic.employee.portal.model.Employee;

public interface EmployeeDAO {
	
	void addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee findEmployeeById(int idEmployee);
	Set<Employee> getEmployees();

}
