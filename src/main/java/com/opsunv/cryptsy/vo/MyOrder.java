package com.opsunv.cryptsy.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyOrder {
	
	@JsonProperty("marketid")
	private int marketId;
	
	//Order ID for this order
	@JsonProperty("orderid")
	private int orderId;
	
	//Datetime the order was created
	private Date created;
	
	//Type of order (Buy/Sell)
	@JsonProperty("ordertype")
	private String orderType;
	
	//The price per unit for this order
	private double price;
	
	//Quantity remaining for this order
	private double quantity;
	
	//Total value of order (price * quantity)
	private double  total;
	
	//Original Total Order Quantity
	@JsonProperty("orig_quantity")
	private double  origQuantity;
	
	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getOrigQuantity() {
		return origQuantity;
	}

	public void setOrigQuantity(double origQuantity) {
		this.origQuantity = origQuantity;
	}
}
