package com.metaphorfe.l2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaphorfe.l2.entity.ContractType;
import com.metaphorfe.l2.entity.StatusTables;
import com.metaphorfe.l2.repository.ContractTypeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContractTypeService {

	/** ContractType Service */
	@Autowired
	private ContractTypeRepository contractTypeRepository;

	public void insertContractTypes() {
		List<ContractType> contractTypes = contractTypeRepository.findAll();

		if (contractTypes.isEmpty()) {
			log.info("Insert Catalog Contract Type");
			ContractType contractType = new ContractType();
			contractType.setName("Permanent");
			contractType.setDescription("Permanent");
			contractType.setStatus(new StatusTables(true, new Date()));
			contractTypeRepository.save(contractType);
			
			contractType = new ContractType();
			contractType.setName("Fixed-Term");
			contractType.setDescription("Fixed-Term");
			contractType.setStatus(new StatusTables(true, new Date()));
			contractTypeRepository.save(contractType);
			
			contractType = new ContractType();
			contractType.setName("External");
			contractType.setDescription("External");
			contractType.setStatus(new StatusTables(true, new Date()));
			contractTypeRepository.save(contractType);
		}
	}

}