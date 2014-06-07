package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.CalculateFeesResponse;

/**
 * Authenticated API <b>calculatefees</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class CalculateFeesRequest extends CryptsyRequest<CalculateFeesResponse>  {
	
	public final static String BUY = "Buy";
	
	public final static String SELL = "Sell";

	//Order type you are calculating for (Buy/Sell)
	private String orderType;
	
	//Amount of units you are buying/selling
	private double quantity;
	
	//	Price per unit you are buying/selling at
	private double price;
	
	public CalculateFeesRequest() {
	}

	public CalculateFeesRequest(String orderType, double quantity, double price) {
		this.orderType = orderType;
		this.quantity = quantity;
		this.price = price;
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
		return "calculatefees";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ordertype", orderType);
		map.put("quantity", String.format("%.8f", quantity));
		map.put("price", String.format("%.8f", price));
		
		return map;
	}
	
}
