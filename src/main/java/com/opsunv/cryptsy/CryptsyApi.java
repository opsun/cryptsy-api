package com.opsunv.cryptsy;

import java.io.IOException;


/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public interface CryptsyApi {
	
	/**
	 * call cryptsy.com api
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 */
	public <T extends Object> T execute(CryptsyRequest<T> request) throws ApiException,IOException;
	
}
