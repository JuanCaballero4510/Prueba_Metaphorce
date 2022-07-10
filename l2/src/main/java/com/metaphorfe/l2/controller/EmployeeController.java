package com.metaphorfe.l2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorfe.l2.entity.Employee;
import com.metaphorfe.l2.entity.response.ServiceResponse;
import com.metaphorfe.l2.entity.view.EmployeeView;
import com.metaphorfe.l2.service.EmployeeService;
import com.metaphorfe.l2.util.ServicesUtil;


@CrossOrigin
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	/** Employee Service */
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping()
	public ResponseEntity<ServiceResponse<List<EmployeeView>>> getAllEmployees() {
		ServiceResponse<List<EmployeeView>> response = employeeService.getAllEmployees();
		return new ResponseEntity<ServiceResponse<List<EmployeeView>>>(response, ServicesUtil.getCodeHttp(response));
	}

	@PostMapping(path = "/insert")
	public ResponseEntity<ServiceResponse<Employee>> insertEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(null);
		ServiceResponse<Employee> response = employeeService.insertUpdateEmployee(employee);
		return new ResponseEntity<ServiceResponse<Employee>>(response, ServicesUtil.getCodeHttp(response));
	}

	@PutMapping(path = "/update/{employeeId}")
	public ResponseEntity<ServiceResponse<Employee>> updateEmployee(@PathVariable(name = "employeeId") Long employeeId, @RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		ServiceResponse<Employee> response = employeeService.insertUpdateEmployee(employee);
		return new ResponseEntity<ServiceResponse<Employee>>(response, ServicesUtil.getCodeHttp(response));
	}

	@DeleteMapping(path = "/delete-contract/{employeeId}")
	public ResponseEntity<ServiceResponse<Employee>> deleteContractEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		ServiceResponse<Employee> response = employeeService.deleteContractEmployee(employeeId);
		return new ResponseEntity<ServiceResponse<Employee>>(response, ServicesUtil.getCodeHttp(response));
	}
	
}