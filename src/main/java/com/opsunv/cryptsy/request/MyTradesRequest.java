package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.MyTradesResponse;
import com.opsunv.cryptsy.vo.MyTrade;

public class MyTradesRequest extends CryptsyRequest<MyTradesResponse>{
	private int marketId;
	
	private int limit = 200;

	/**
	 * default limit 200
	 * @param marketId
	 */
	public MyTradesRequest(int marketId) {
		this.marketId = marketId;
	}
	
	public MyTradesRequest(int marketId, int limit) {
		this.marketId = marketId;
		this.limit = limit;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String getMethod() {
		return "mytrades";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		map.put("limit", limit+"");
		return map;
	}
	
	@Override
	public MyTradesResponse parse(JsonNode json) {
		MyTradesResponse response = super.parse(json);
		
		if(response.getTrades()!=null){
			for(MyTrade trade : response.getTrades()){
				trade.setMarketId(marketId);
			}
		}

		
		return response;
	}
	
}
