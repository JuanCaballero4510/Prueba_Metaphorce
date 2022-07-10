package com.metaphorfe.l2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.metaphorfe.l2.entity.Employee;



@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	List<Employee> findAll();
	
	Optional<Employee> findByTaxIdNumber(String taxIdNumber);
	
}