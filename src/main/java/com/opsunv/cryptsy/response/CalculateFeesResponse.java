package com.opsunv.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CalculateFeesResponse {
	//The that would be charged for provided inputs
	private double fee;
	
	//The net total with fees
	private double net;

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getNet() {
		return net;
	}

	public void setNet(double net) {
		this.net = net;
	}
	
}
