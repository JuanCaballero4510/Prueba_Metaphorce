package com.metaphorfe.l2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.metaphorfe.l2.constants.MsgErrores;
import com.metaphorfe.l2.entity.Contract;
import com.metaphorfe.l2.entity.Employee;
import com.metaphorfe.l2.entity.response.ServiceResponse;
import com.metaphorfe.l2.repository.ContractRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContractService {

	/** Contract Service */
	@Autowired
	private ContractRepository contractRepository;
	
	/** Employee Service */
	@Autowired
	private EmployeeService employeeService;
	

	private List<Contract> getContractsByEmployeeId(Employee employee) {
		return contractRepository.findByEmployeeId(employee);
	}

	public boolean ifContractActiveByEmployeeId(Employee employee) {
		boolean contractsActive = false;
		
		for (Contract contract : getContractsByEmployeeId(employee)) {
			if(contract.getStatus().getIsActive().booleanValue()) {
				contract.getStatus().setIsActive(false);
				contract.setDateTo(new Date());
				contractRepository.save(contract);
				contractsActive = true;
			}
		}
		
		return contractsActive;
	}
	
	public Optional<Contract> getEmployeeActive(Employee employee) {
		return contractRepository.findByEmployeedIdAndIsActive(employee.getEmployeeId(), true);
	}

	public ServiceResponse<Contract> insertContract(Contract contract) {
		ServiceResponse<Contract> response = new ServiceResponse<>();

		try {
			Optional<Employee> employee = employeeService.getEmployeeById(contract.getEmployeeId().getEmployeeId());
			
			if(employee.isPresent()) {
				ifContractActiveByEmployeeId(contract.getEmployeeId());
				contract.getStatus().setDateCreated(new Date());
				contract.getStatus().setIsActive(true);
				
				response.setResponse(contractRepository.save(contract));
				response.setSuccessful(true);
			} else {
				response.addError(MsgErrores.COD_500, MsgErrores.MSG_ERROR_EMPLOYEE_EXISTS);
			}
		} catch (DataIntegrityViolationException ex) {
			log.error(MsgErrores.MSG_EXCEPTION,  ex.getRootCause().getMessage());
			response.addError(MsgErrores.COD_500, ex.getRootCause().getMessage());
		} catch (Exception e) {
			log.error(MsgErrores.MSG_EXCEPTION,  e.getMessage());
			response.addError(MsgErrores.COD_500, MsgErrores.MSG_500);
		}

		return response;
	}
	
}