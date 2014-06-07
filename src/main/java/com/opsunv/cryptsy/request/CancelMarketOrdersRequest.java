package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;

/**
 * Authenticated API <b>cancelmarketorders</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class CancelMarketOrdersRequest extends CryptsyRequest<Boolean> {
	
	private int marketId;
	
	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "cancelmarketorders";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		return map;
	}

	@Override
	public Boolean parse(JsonNode json) {
		return true;
	}
}
