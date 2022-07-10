package com.metaphorfe.l2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class GeneralUtil {
	
    public static boolean validateRFCFormat(String rfc) {
    	String regex = "^[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?$";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(rfc.trim().toUpperCase());
    	
        return matcher.matches();
    }
    
}
