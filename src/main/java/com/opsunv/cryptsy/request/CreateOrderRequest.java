package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;

/**
 * Authenticated API <b>createorder</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a><br>
 * If successful, the Order ID for the order which was created.
 * If unsuccessful, this request will throw ApiException
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class CreateOrderRequest extends CryptsyRequest<Integer> {
	public final static String BUY = "Buy";
	
	public final static String SELL = "Sell";
	
	//Market ID for which you are creating an order for
	private int marketId;
	
	//Order type you are creating (Buy/Sell)
	private String orderType;
	
	//Amount of units you are buying/selling in this order
	private double quantity;
	
	//Price per unit you are buying/selling at
	private double price;
	
	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getMethod() {
		return "createorder";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		map.put("ordertype", orderType);
		map.put("quantity", String.format("%.8f", quantity));
		map.put("price", String.format("%.8f", price));
		return map;
	}
	
	@Override
	public Integer parse(JsonNode json) {
		return json.get("orderid").asInt();
	}
}
