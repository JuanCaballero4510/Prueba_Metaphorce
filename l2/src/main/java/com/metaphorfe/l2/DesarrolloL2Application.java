package com.metaphorfe.l2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.metaphorfe.l2.service.ContractTypeService;

@SpringBootApplication
public class DesarrolloL2Application implements CommandLineRunner {
	
	@Autowired
	private ContractTypeService contractTypeService;
	
	public static void main(String[] args) {
		SpringApplication.run(DesarrolloL2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		contractTypeService.insertContractTypes();
	}
	
}
