package com.opsunv.cryptsy.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MarketTrade {
	@JsonProperty("tradeid")
	private int id;
	
	private Date datetime;
	
	@JsonProperty("tradeprice")
	private double price;
	
	private double quantity;
	
	private double total;;
	
	@JsonProperty("initiate_ordertype")
	private String orderType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
}
