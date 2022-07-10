package com.metaphorfe.l2.entity.response;

import java.io.Serializable;

public class ServiceError implements Serializable {
	
    /** Serial Version */
    private static final long serialVersionUID = -1;
    
    
    private String code;
    
    private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
    
}
