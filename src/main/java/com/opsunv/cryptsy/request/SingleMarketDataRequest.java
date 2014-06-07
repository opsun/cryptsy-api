package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.SingleMarketDataResponse;
import com.opsunv.cryptsy.utils.ParseUtils;

/**
 * public API <b>singlemarketdata</b><br>
 * http://pubapi.cryptsy.com/api.php?method=singlemarketdata&amp;marketid=xx
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class SingleMarketDataRequest extends CryptsyRequest<SingleMarketDataResponse> {
	private int marketId;
	
	public int getMarketId() {
		return marketId;
	}
	
	/**
	 * set marketid parameter
	 * @param marketId
	 */
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "singlemarketdata";
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
	public SingleMarketDataResponse parse(JsonNode json) {
		SingleMarketDataResponse response = new SingleMarketDataResponse();
		json = json.get("markets");
		Iterator<?> iterator = json.elements();
		if(iterator.hasNext()){
			response = ParseUtils.convertValue(iterator.next(),SingleMarketDataResponse.class);
		}
		
		return response;
	}
	
}
