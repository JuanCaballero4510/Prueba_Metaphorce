package com.metaphorfe.l2.entity.view;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaphorfe.l2.constants.Settings;

import lombok.Data;

@Data
public class EmployeeView implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1L;
	
	private String fullName;

	private String taxIdNumber;

	private String email;

	private String contractTypeName;

	@JsonFormat(pattern = Settings.FORMAT_DATE)
    private Date contractDateFrom;
	
	@JsonFormat(pattern = Settings.FORMAT_DATE)
    private Date contractDateTo;
	
	private Double contractSalaryPerDay;
	
}