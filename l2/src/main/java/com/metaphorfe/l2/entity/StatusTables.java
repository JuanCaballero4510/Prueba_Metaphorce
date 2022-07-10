package com.metaphorfe.l2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaphorfe.l2.constants.Settings;

import lombok.Data;
import lombok.NonNull;

@Embeddable
@Data
public class StatusTables implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1L;

	@NonNull
	private Boolean isActive;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = Settings.FORMAT_DATE)
	private Date dateCreated;

	public StatusTables() {
	}

	public StatusTables(@NonNull Boolean isActive, @NonNull Date dateCreated) {
		super();
		this.isActive = isActive;
		this.dateCreated = dateCreated;
	}
	
}