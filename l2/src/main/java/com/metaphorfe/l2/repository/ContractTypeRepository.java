package com.metaphorfe.l2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.metaphorfe.l2.entity.ContractType;



@RepositoryRestResource
public interface ContractTypeRepository extends CrudRepository<ContractType, Long> {
	
	@Override
	List<ContractType> findAll();

}