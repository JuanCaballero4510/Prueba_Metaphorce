package com.metaphorfe.l2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.metaphorfe.l2.entity.Contract;
import com.metaphorfe.l2.entity.Employee;


@RepositoryRestResource
public interface ContractRepository extends CrudRepository<Contract, Long> {
	
	@Override
	List<Contract> findAll();
	
	@Query("SELECT c FROM Contract c JOIN c.employeeId e WHERE e.employeeId = :employeeId AND c.status.isActive = :isActive ")
	Optional<Contract> findByEmployeedIdAndIsActive(Long employeeId, Boolean isActive);
	
	List<Contract> findByEmployeeId(Employee employeeId);
	
}