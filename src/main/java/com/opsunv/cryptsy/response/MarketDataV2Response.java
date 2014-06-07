package com.opsunv.cryptsy.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.MarketData;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class MarketDataV2Response{
	
	@JsonProperty("markets")
	private Map<String, MarketData>  marketData = new HashMap<String, MarketData>();

	public Map<String, MarketData> getMarketData() {
		return marketData;
	}

	public void setMarketData(Map<String, MarketData> marketData) {
		this.marketData = marketData;
	}
	
	

}
