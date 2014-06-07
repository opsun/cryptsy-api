package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;

/**
 * Authenticated API <b>makewithdrawal</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a><br>
 * 
 * if successful return true,else throw ApiException
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MakeWithdrawalRequest extends CryptsyRequest<Boolean>{
	private String address;
	
	private double amount;

	public MakeWithdrawalRequest(String address, double amount) {
		this.address = address;
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String getMethod() {
		return "makewithdrawal";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("address", address);
		map.put("amount", String.format("%.8f", amount));
		
		return map;
	}
	
	@Override
	public Boolean parse(JsonNode json) {
		return true;
	}
	
}
