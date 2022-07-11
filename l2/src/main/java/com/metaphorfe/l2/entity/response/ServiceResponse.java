package com.metaphorfe.l2.entity.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ServiceResponse<T> implements Serializable {
	
    /** Serial Version */
    private static final long serialVersionUID = -1;

    
    public ServiceResponse() {
        this.successful = false;
        this.errors = new ArrayList<>();
    }

    private boolean successful;
    
    private T response;
    
    private List<ServiceError> errors;
    
    public void addError(String code, String mensaje) {
        ServiceError serviceError = new ServiceError();
        serviceError.setCode(code);
        serviceError.setMessage(mensaje);
        this.errors.add(serviceError);
        this.response = null;
        this.successful = false;
    }

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
		this.errors = null;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public List<ServiceError> getErrors() {
		return errors;
	}
	
}
