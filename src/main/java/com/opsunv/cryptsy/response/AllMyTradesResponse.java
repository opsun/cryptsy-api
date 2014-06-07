package com.opsunv.cryptsy.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.MyTrade;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyTradesResponse {
	
	@JsonProperty("return")
	private List<MyTrade> trades = new ArrayList<MyTrade>();

	public List<MyTrade> getTrades() {
		return trades;
	}

	public void setTrades(List<MyTrade> trades) {
		this.trades = trades;
	}
	
}
