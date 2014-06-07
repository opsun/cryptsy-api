package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;

/**
 * Authenticated API <b>cancelorder</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a><br>
 * 
 * If the order is not exists or the order does not appear to belong to you,the request will throw ApiException.
 * If cancel order successful, it will return true.
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class CancelOrderRequest extends CryptsyRequest<Boolean> {
	private int orderId;
	
	/**
	 * Order ID for which you would like to cancel
	 * @param orderId
	 */
	public CancelOrderRequest(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	/**
	 * Order ID for which you would like to cancel
	 * @param orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String getMethod() {
		return "cancelorder";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderid", orderId+"");
		return map;
	}
	
	@Override
	public Boolean parse(JsonNode json) {
		//if successful, it will return true for this api.
		return true;
	}

}
