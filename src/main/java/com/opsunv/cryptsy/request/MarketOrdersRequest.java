package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.MarketordersResponse;

/**
 * Authenticated API <b>marketorders</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MarketOrdersRequest extends CryptsyRequest<MarketordersResponse> {
	private int marketId;
	
	public MarketOrdersRequest(int marketId) {
		this.marketId = marketId;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "marketorders";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		return map;
	}
	
	@Override
	public MarketordersResponse parse(JsonNode json) {
		changeFieldName((ArrayNode)json.get("sellorders"),"sellprice");
		changeFieldName((ArrayNode)json.get("buyorders"),"buyprice");
		
		return super.parse(json);
	}
	
	private void changeFieldName(ArrayNode arr,String fieldName){
		Iterator<JsonNode> iterator = arr.elements();
		while(iterator.hasNext()){
			ObjectNode obj = (ObjectNode)iterator.next();
			JsonNode jn = obj.get(fieldName);
			obj.remove(fieldName);
			obj.put("price", jn);
		}
	}

}
