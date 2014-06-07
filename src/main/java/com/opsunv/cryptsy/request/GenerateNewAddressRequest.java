package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.utils.Assert;

/**
 * Authenticated API <b>generatenewaddress</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a><br>
 * 
 * either currencyid OR currencycode required - you do not have to supply both
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class GenerateNewAddressRequest extends CryptsyRequest<String> {
	
	//Currency ID for the coin you want to generate a new address for (ie. 3 = BitCoin)
	private int currencyId;
	
	//Currency Code for the coin you want to generate a new address for (ie. BTC = BitCoin)
	private String currencyCode;
	
	
	public int getCurrencyId() {
		return currencyId;
	}

	/**
	 * Currency ID for the coin you want to generate a new address for (ie. 3 = BitCoin)
	 * @param currencyId
	 */
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}
	
	/**
	 * Currency Code for the coin you want to generate a new address for (ie. BTC = BitCoin)
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String getMethod() {
		return "generatenewaddress";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		if(Assert.isEmpty(currencyCode)){
			map.put("currencyid", currencyId+"");
		}else{
			map.put("currencycode", currencyCode);
		}
		
		return map;
	}
	
	@Override
	public String parse(JsonNode json) {
		return json.get("address").asText();
	}
}
