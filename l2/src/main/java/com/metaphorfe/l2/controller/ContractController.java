package com.metaphorfe.l2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorfe.l2.entity.Contract;
import com.metaphorfe.l2.entity.response.ServiceResponse;
import com.metaphorfe.l2.service.ContractService;
import com.metaphorfe.l2.util.ServicesUtil;


@CrossOrigin
@RestController
@RequestMapping(value = "/contracts")
public class ContractController {
	
	/** Contract Service */
	@Autowired
	private ContractService contractService;
	

	@PostMapping(path = "/insert")
	public ResponseEntity<ServiceResponse<Contract>> insertContract(@RequestBody Contract contract) {
		ServiceResponse<Contract> response = contractService.insertContract(contract);
		return new ResponseEntity<ServiceResponse<Contract>>(response, ServicesUtil.getCodeHttp(response));
	}
	
}