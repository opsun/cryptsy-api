package com.opsunv.cryptsy;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class ApiException extends Exception{

	private static final long serialVersionUID = 5002111555196573216L;
	
	public ApiException(String msg) {
		super(msg);
	}

}
