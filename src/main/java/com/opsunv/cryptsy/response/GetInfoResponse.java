package com.opsunv.cryptsy.response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class GetInfoResponse {
	@JsonProperty("balances_available")
	private Map<String, Double> balancesAvailable = new HashMap<String, Double>();
	
	@JsonProperty("balances_available_btc")
	private Map<String, Double> balancesAvailableBtc = new HashMap<String, Double>();
	
	@JsonProperty("servertimestamp")
	private long serverTimestamp;
	
	@JsonProperty("servertimezone")
	private String serverTimezone;
	
	@JsonProperty("serverdatetime")
	private Date serverDatetime;
	
	@JsonProperty("openordercount")
	private int openOrderCount;

	public Map<String, Double> getBalancesAvailable() {
		return balancesAvailable;
	}

	public void setBalancesAvailable(Map<String, Double> balancesAvailable) {
		this.balancesAvailable = balancesAvailable;
	}

	public Map<String, Double> getBalancesAvailableBtc() {
		return balancesAvailableBtc;
	}

	public void setBalancesAvailableBtc(Map<String, Double> balancesAvailableBtc) {
		this.balancesAvailableBtc = balancesAvailableBtc;
	}

	public long getServerTimestamp() {
		return serverTimestamp;
	}

	public void setServerTimestamp(long serverTimestamp) {
		this.serverTimestamp = serverTimestamp;
	}

	public String getServerTimezone() {
		return serverTimezone;
	}

	public void setServerTimezone(String serverTimezone) {
		this.serverTimezone = serverTimezone;
	}

	public Date getServerDatetime() {
		return serverDatetime;
	}

	public void setServerDatetime(Date serverDatetime) {
		this.serverDatetime = serverDatetime;
	}

	public int getOpenOrderCount() {
		return openOrderCount;
	}

	public void setOpenOrderCount(int openOrderCount) {
		this.openOrderCount = openOrderCount;
	}
	
}
