package com.metaphorfe.l2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.metaphorfe.l2.constants.MsgErrores;
import com.metaphorfe.l2.entity.Contract;
import com.metaphorfe.l2.entity.Employee;
import com.metaphorfe.l2.entity.response.ServiceResponse;
import com.metaphorfe.l2.entity.view.EmployeeView;
import com.metaphorfe.l2.repository.EmployeeRepository;
import com.metaphorfe.l2.util.GeneralUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

	/** Employee Repository */
	@Autowired
	private EmployeeRepository employeeRepository;

	/** Contract Service */
	@Autowired
	private ContractService contractService;
	
	
	public Optional<Employee> getEmployeeById(Long employeeId){
		return employeeRepository.findById(employeeId);
	}
	
	public ServiceResponse<List<EmployeeView>> getAllEmployees() {
		ServiceResponse<List<EmployeeView>> response = new ServiceResponse<>();

		try {
			List<EmployeeView> employeeViews = new ArrayList<>();
			List<Employee> employees = employeeRepository.findAll();
			
			if (employees.isEmpty()) {
				response.addError(MsgErrores.COD_404, MsgErrores.MSG_404);
			} else {
				for (Employee employee : employees) {
					EmployeeView view = new EmployeeView();
					view.setFullName(employee.getName().concat(" ").concat(employee.getLastName()));
					view.setTaxIdNumber(employee.getTaxIdNumber());
					view.setEmail(employee.getEmail());
					//Contract
					Optional<Contract> contract = contractService.getEmployeeActive(employee);
					if(contract.isPresent()) {
						view.setContractTypeName(contract.get().getContractTypeId().getName());
						view.setContractDateFrom(contract.get().getDateFrom());
						view.setContractDateTo(contract.get().getDateTo());
						view.setContractSalaryPerDay(contract.get().getSalaryPerDay());
					}
					
					employeeViews.add(view);
				}
				
				response.setResponse(employeeViews);
				response.setSuccessful(true);
			}
		} catch (Exception e) {
			log.error(MsgErrores.MSG_EXCEPTION,  e.getMessage());
			response.addError(MsgErrores.COD_500, MsgErrores.MSG_500);
		}

		return response;
	}

	public ServiceResponse<Employee> insertEmployee(Employee employee) {
		ServiceResponse<Employee> response = new ServiceResponse<>();

		try {
			//check format RFC
			if(GeneralUtil.validateRFCFormat(employee.getTaxIdNumber())) {
				Optional<Employee> rfcEmployee = employeeRepository.findByTaxIdNumber(employee.getTaxIdNumber());
				if(rfcEmployee.isPresent()) {
					response.addError(MsgErrores.COD_500, MsgErrores.MSG_ERROR_RFC_EXISTS);
				} else {
					response.setResponse(employeeRepository.save(employee));
					response.setSuccessful(true);
				}
			} else {
				response.addError(MsgErrores.COD_500, MsgErrores.MSG_ERROR_FORMAT_RFC);
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

	public ServiceResponse<Employee> updateEmployee(Employee employee) {
		ServiceResponse<Employee> response = new ServiceResponse<>();

		try {
			//check format RFC
			if(GeneralUtil.validateRFCFormat(employee.getTaxIdNumber())) {
				Optional<Employee> rfcEmployee = employeeRepository.findByTaxIdNumber(employee.getTaxIdNumber());
				if(rfcEmployee.isPresent()) {
					if(rfcEmployee.get().getEmployeeId().intValue() != employee.getEmployeeId()) {
						response.addError(MsgErrores.COD_500, MsgErrores.MSG_ERROR_RFC_EXISTS);
					} else {
						response.setResponse(employeeRepository.save(employee));
						response.setSuccessful(true);
					}
				} else {
					response.setResponse(employeeRepository.save(employee));
					response.setSuccessful(true);
				}
			} else {
				response.addError(MsgErrores.COD_500, MsgErrores.MSG_ERROR_FORMAT_RFC);
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

	public ServiceResponse<Employee> deleteContractEmployee(Long employeeId) {
		ServiceResponse<Employee> response = new ServiceResponse<>();

		try {
			Optional<Employee> employee = getEmployeeById(employeeId);
			
			if(employee.isPresent()) {
				if(contractService.ifContractActiveByEmployeeId(new Employee(employeeId))) {
					response.setResponse(employee.get());
					response.setSuccessful(true);
				} else {
					response.addError(MsgErrores.COD_500, MsgErrores.MSG_ERROR_CONTRACT_EXISTS);
				}
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