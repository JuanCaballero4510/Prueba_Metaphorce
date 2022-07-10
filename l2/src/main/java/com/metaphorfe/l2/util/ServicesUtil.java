package com.metaphorfe.l2.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.metaphorfe.l2.constants.MsgErrores;
import com.metaphorfe.l2.entity.response.ServiceResponse;


public final class ServicesUtil {
	
    private ServicesUtil() {
        super();
    }
    
    
    public static ResponseEntity<?> validaRespuesta(ServiceResponse<?> response) {
    	return new ResponseEntity<>(response, getCodeHttp(response));
    }
    
    public static HttpStatus getCodeHttp(ServiceResponse<?> response) {
        HttpStatus valor = HttpStatus.OK;
        
        if(response.isSuccessful()) {
            return valor;
        } else {
            switch(response.getErrors().get(0).getCode()) {
                case MsgErrores.COD_404:
                    valor = HttpStatus.NOT_FOUND;
                    break;
                case MsgErrores.COD_400:
                    valor = HttpStatus.BAD_REQUEST;
                    break;
                case MsgErrores.COD_500:
                    valor = HttpStatus.INTERNAL_SERVER_ERROR;
                    break;
                default:
                    valor = HttpStatus.BAD_REQUEST;
                    break;
            }
        }
        
        return valor;
    }
    
}
