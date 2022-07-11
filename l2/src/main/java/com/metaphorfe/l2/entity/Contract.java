package com.metaphorfe.l2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaphorfe.l2.constants.Settings;

import lombok.Data;
import lombok.NonNull;


@Entity
@Data
public class Contract implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -3904251195338397177L;
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "Contract_contractId_Seq")
	@SequenceGenerator(
			name = "Contract_contractId_Seq",
			sequenceName = "contractId_Seq",
			allocationSize = 1
	)
	private Long contractId;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = Settings.FORMAT_DATE)
    private Date dateFrom;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = Settings.FORMAT_DATE)
    private Date dateTo;
	
	@NonNull
	private Double salaryPerDay;
	
	@Embedded
	private StatusTables status;

	@OneToOne
	@JoinColumn(name = "contratTypeId")
	private ContractType contractTypeId;
	
	@OneToOne
	@JoinColumn(name = "employeeId")
	private Employee employeeId;

    public Contract() {
        super();
    }
    
    public Contract(Long contractId) {
        this.contractId = contractId;
    }
    
}