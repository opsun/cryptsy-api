package com.opsunv.cryptsy.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MarketData extends Market{
	
	@JsonProperty("lasttradeprice")
	private double lastTradePrice;
	
	private double volume;
	
	@JsonProperty("lasttradetime")
	private Date lastTradeTime; 
	
	@JsonProperty("recenttrades")
	private List<TradeOrder> recentTrades;
	
	@JsonProperty("sellorders")
	private List<Order> sellOrders;
	
	@JsonProperty("buyorders")
	private List<Order> buyOrders;

	public double getLastTradePrice() {
		return lastTradePrice;
	}

	public void setLastTradePrice(double lastTradePrice) {
		this.lastTradePrice = lastTradePrice;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Date getLastTradeTime() {
		return lastTradeTime;
	}

	public void setLastTradeTime(Date lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}

	public List<TradeOrder> getRecentTrades() {
		return recentTrades;
	}

	public void setRecentTrades(List<TradeOrder> recentTrades) {
		this.recentTrades = recentTrades;
	}

	public List<Order> getSellOrders() {
		return sellOrders;
	}

	public void setSellOrders(List<Order> sellOrders) {
		this.sellOrders = sellOrders;
	}

	public List<Order> getBuyOrders() {
		return buyOrders;
	}

	public void setBuyOrders(List<Order> buyOrders) {
		this.buyOrders = buyOrders;
	}

}
