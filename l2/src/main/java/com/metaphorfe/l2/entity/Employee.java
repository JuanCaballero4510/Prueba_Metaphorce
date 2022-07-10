package com.metaphorfe.l2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaphorfe.l2.constants.Settings;

import lombok.Data;
import lombok.NonNull;


@Entity
@Data
public class Employee implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1L;
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "Employee_employeeId_Seq")
	@SequenceGenerator(
			name = "Employee_employeeId_Seq",
			sequenceName = "employeeId_Seq",
			allocationSize = 1
	)
	private Long employeeId;
	
	/**
	 * RFC
	 */
	@Column(length = 13, unique = true)
	@NonNull
	private String taxIdNumber;
	
	@Column(length = 60)
	@NonNull
	private String name;

	@Column(length = 120)
	@NonNull
	private String lastName;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = Settings.FORMAT_DATE)
    private Date birthDate;

	@Column(length = 60)
	@NonNull
	private String email;
	
	@Column(length = 20)
	@NonNull
	private String cellPhone;

	@Embedded
	private StatusTables status;

    public Employee() {
        super();
    }
    
    public Employee(Long employeeId) {
        this.employeeId = employeeId;
    }
    
}