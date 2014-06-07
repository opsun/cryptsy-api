package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.MarketTradesResponse;

public class MarketTradesRequest extends CryptsyRequest<MarketTradesResponse> {
	
	private int marketId;
	
	public MarketTradesRequest(int marketId) {
		this.marketId = marketId;
	}
	
	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "markettrades";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		return map;
	}
	
}
