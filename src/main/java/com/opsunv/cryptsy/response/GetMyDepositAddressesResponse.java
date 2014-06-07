package com.opsunv.cryptsy.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class GetMyDepositAddressesResponse {
	
	@JsonProperty("return")
	private Map<String, String> depositAddresses = new HashMap<String, String>();
	
	/**
	 * get the specified deposit addresse
	 * @param coin
	 * @return
	 */
	public String getAddress(String coin){
		return depositAddresses.get(coin);
	}

	public Map<String, String> getDepositAddresses() {
		return depositAddresses;
	}

	public void setDepositAddresses(Map<String, String> depositAddresses) {
		this.depositAddresses = depositAddresses;
	}
	
}
