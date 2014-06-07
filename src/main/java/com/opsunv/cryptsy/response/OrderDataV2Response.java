package com.opsunv.cryptsy.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.OrderData;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class OrderDataV2Response {
	
	@JsonProperty("return")
	private Map<String, OrderData> orderData = new HashMap<String, OrderData>();

	public Map<String, OrderData> getOrderData() {
		return orderData;
	}

	public void setOrderData(Map<String, OrderData> orderData) {
		this.orderData = orderData;
	}
	
}
