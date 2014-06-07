package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.MyOrdersResponse;
import com.opsunv.cryptsy.vo.MyOrder;

/**
 * Authenticated API <b>myorders</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MyOrdersRequest extends CryptsyRequest<MyOrdersResponse> {
	
	//Market ID for which you are querying
	private int marketId;
	
	/**
	 * 
	 * @param marketId Market ID for which you are querying
	 */
	public MyOrdersRequest(int marketId) {
		this.marketId = marketId;
	}

	public int getMarketId() {
		return marketId;
	}

	/**
	 * Market ID for which you are querying
	 * @param marketId
	 */
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "myorders";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		return map;
	}
	
	@Override
	public MyOrdersResponse parse(JsonNode json) {
		MyOrdersResponse response = super.parse(json);
		
		if(response.getOrders()!=null){
			for(MyOrder myOrder : response.getOrders()){
				myOrder.setMarketId(marketId);
			}
		}
		
		return response;
	}
	
}
