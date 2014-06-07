package com.opsunv.cryptsy.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class OrderData extends Market {
	
	@JsonProperty("sellorders")
	private List<Order> sellOrders;
	
	@JsonProperty("buyorders")
	private List<Order> buyOrders;

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
