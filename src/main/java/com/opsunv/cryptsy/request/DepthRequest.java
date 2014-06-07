package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.DepthResponse;

/**
 * Authenticated API <b>depth</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class DepthRequest extends CryptsyRequest<DepthResponse> {
	private int marketId;
	
	public DepthRequest(int marketId) {
		this.marketId = marketId;
	}

	public int getMarketId() {
		return marketId;
	}

	/**
	 * Market ID for which you are queryin
	 * @param marketId
	 */
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "depth";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		return map;
	}
	
	@Override
	public DepthResponse parse(JsonNode json) {
		System.out.println(json);
		return super.parse(json);
	}

}
