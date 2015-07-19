package com.opsunv.cryptsy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsunv.cryptsy.utils.WebUtils;

/**
 * An implementation of the Cryptsy public API
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class PublicCryptsyApi extends AbstractCryptsyApi{
	private final static String DEFAULT_PUB_API = "http://pubapi.cryptsy.com/api.php";
	
	private String apiUrl;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public PublicCryptsyApi() {
		this(null);
	}
	
	public PublicCryptsyApi(String apiUrl) {
		this.apiUrl = apiUrl;
		if(this.apiUrl==null){
			apiUrl = DEFAULT_PUB_API;
		}
	}

	@Override
	protected JsonNode query(String method,Map<String, String> params) throws IOException{
		Map<String, String> map = new HashMap<String, String>();
		if(params!=null){
			map.putAll(params);
		}
		map.put("method", method);
		return objectMapper.readTree(WebUtils.doGet(apiUrl, map));
	}
	
}
