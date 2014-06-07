package com.opsunv.cryptsy.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.MyOrder;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyOrdersResponse {
	
	@JsonProperty("return")
	private List<MyOrder> orders = new ArrayList<MyOrder>();

	public List<MyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MyOrder> orders) {
		this.orders = orders;
	}
	
}
