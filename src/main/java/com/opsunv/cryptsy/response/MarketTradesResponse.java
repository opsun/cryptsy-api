package com.opsunv.cryptsy.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.MarketTrade;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MarketTradesResponse {
	
	@JsonProperty("return")
	private List<MarketTrade> trades = new ArrayList<MarketTrade>();

	public List<MarketTrade> getTrades() {
		return trades;
	}

	public void setTrades(List<MarketTrade> trades) {
		this.trades = trades;
	}
	
}
