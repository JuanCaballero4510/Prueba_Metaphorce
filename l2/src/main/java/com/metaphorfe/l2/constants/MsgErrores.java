package com.metaphorfe.l2.constants;

public final class MsgErrores {
	
	public static final String MSG_EXCEPTION = "Error Message: {}";
	
	/** Codigo HTTP 500 -- Internal Server Error*/
	public static final String COD_500 = "500";
	public static final String MSG_500 = "Sorry, we found a problem with the service, please try again later.";
	/** Codigo HTTP 400 -- Bad Request */
	public static final String COD_400 = "400";
	public static final String MSG_400 = "This service isn´t working.";
	/** Codigo HTTP 404 -- Unauthorized */
	public static final String COD_401 = "401";
	public static final String MSG_401 = "The user is not authorized to execute this option.";
	/** Codigo HTTP 404 -- Not Found */
	public static final String COD_404 = "404";
	public static final String MSG_404 = "No information found in the database.";
	
	/** Messages **/
	public static final String MSG_ERROR_FORMAT_RFC = "RFC format is incorrect";
	public static final String MSG_ERROR_RFC_EXISTS = "RFC already exists";
	public static final String MSG_ERROR_CONTRACT_EXISTS = "The contract does not exist";
	public static final String MSG_ERROR_EMPLOYEE_EXISTS = "The employee does not exist";
	
	
	
	/**
	 * Constructor oculto y vacio clase utilitaria.
	 */
	private MsgErrores() {
		super();
	}
}
