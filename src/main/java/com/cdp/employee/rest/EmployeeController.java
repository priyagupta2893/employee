package com.cdp.employee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdp.employee.models.EmployeeDetails;
import com.cdp.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping(value="/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDetails> getEmployee(@RequestParam int empId) {
		EmployeeDetails employee = service.getEmployeeDetails(empId);
		return new ResponseEntity<EmployeeDetails>(employee, HttpStatus.OK) ;
	}
}
