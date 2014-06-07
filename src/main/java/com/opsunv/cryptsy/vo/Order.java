package com.opsunv.cryptsy.vo;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class Order {
	private double price;
	
	private double quantity;
	
	private double total;

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
}
