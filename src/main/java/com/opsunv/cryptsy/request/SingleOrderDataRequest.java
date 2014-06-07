package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.SingleOrderDataResponse;
import com.opsunv.cryptsy.utils.ParseUtils;

/**
 * public API <b>singleorderdata</b><br>
 * http://pubapi.cryptsy.com/api.php?method=singleorderdata&amp;marketid=xx
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class SingleOrderDataRequest extends CryptsyRequest<SingleOrderDataResponse>{
	private int marketId;
	

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "singleorderdata";
	}
	
	@Override
	public boolean auth() {
		return false;
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("marketid", marketId+"");
		return params;
	}
	
	@Override
	public SingleOrderDataResponse parse(JsonNode json) {
		SingleOrderDataResponse response = new SingleOrderDataResponse();
		Iterator<?> iterator = json.elements();
		if(iterator.hasNext()){
			response = ParseUtils.convertValue(iterator.next(),SingleOrderDataResponse.class);
		}
		
		return response;
	}

}
