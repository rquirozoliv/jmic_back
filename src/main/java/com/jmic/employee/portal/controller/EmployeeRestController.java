package com.jmic.employee.portal.controller;

import java.util.List;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmic.employee.portal.model.Employee;
import com.jmic.employee.portal.repository.EmployeeRepository;
@CrossOrigin
@RestController
@RequestMapping("api/")
public class EmployeeRestController {
		
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List <Employee> getAllEmployees() {
		return employeeRepository.findAll();
		
	}
	
	@GetMapping(value = "/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") int idEmployee) {
		return employeeRepository.findById(idEmployee);
	}

	@PutMapping(value="employees/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") int idEmployee, @Valid @RequestBody Employee empl) {
		Employee e = employeeRepository.findById(idEmployee);
			e.setActive(empl.isActive());
			e.setNameEmployee(empl.getNameEmployee());
			e.setLastNameEmployee(empl.getLastNameEmployee());
			e.setDesignation(empl.getDesignation());
			e.setProjects(empl.getProjects());
			e.setJoinDate(empl.getJoinDate());
			employeeRepository.save(e);
		return ResponseEntity.ok().body(e);
		
	}
	
	@PostMapping(value = "/new-employees")
	public Employee addEmployee(@Valid @RequestBody Employee empl) {
		empl.set_id(ObjectId.get());
		empl.setActive(true);
		employeeRepository.save(empl);
		return empl;
	}
	
}

