package com.metaphorfe.l2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NonNull;


@Entity
@Data
public class ContractType implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1L;
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "ContractType_contractTypeId_Seq")
	@SequenceGenerator(
			name = "ContractType_contractTypeId_Seq",
			sequenceName = "contractTypeId_Seq",
			allocationSize = 1
	)
	private Long contractTypeId;
	
	@Column(length = 80)
	@NonNull
	private String name;

	@Column(length = 255)
	private String description;
	
	@Embedded
	private StatusTables status;
	
	public ContractType() {
		
	}

}