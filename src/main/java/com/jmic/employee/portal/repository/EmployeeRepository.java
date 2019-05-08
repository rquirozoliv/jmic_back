package com.jmic.employee.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jmic.employee.portal.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{
	Employee findById(int idEmployee);

}
