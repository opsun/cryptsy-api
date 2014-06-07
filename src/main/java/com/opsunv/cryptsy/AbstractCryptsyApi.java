package com.opsunv.cryptsy;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.utils.Assert;

public abstract class AbstractCryptsyApi implements CryptsyApi {
	
	/**
	 * to encapsulate the query data and request API<br>
	 * Public API and Authenticated API have different implementation<br>
	 * @param method
	 * @param params
	 * @return
	 * @throws IOException
	 */
	protected abstract JsonNode query(String method,Map<String, String> params) throws IOException;
	
	@Override
	public <T extends Object> T execute(CryptsyRequest<T> request) throws ApiException,IOException{
		if(request==null){
			throw new NullPointerException();
		}
		
		if(Assert.isEmpty(request.getMethod())){
			throw new ApiException("method is required");
		}
		
		JsonNode json = query(request.getMethod(),request.getParams());
		int success = json.get("success").asInt();
		if(success==0){
			throw new ApiException(json.get("error").asText());
		}
		
		
		return request.parse( json.has("return")?json.get("return"):json);
	}
}
