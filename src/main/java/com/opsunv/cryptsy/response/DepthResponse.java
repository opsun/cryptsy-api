package com.opsunv.cryptsy.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class DepthResponse {
	private List<Double[]> sell = new ArrayList<Double[]>();
	
	private List<Double[]> buy = new ArrayList<Double[]>();

	public List<Double[]> getSell() {
		return sell;
	}

	public void setSell(List<Double[]> sell) {
		this.sell = sell;
	}

	public List<Double[]> getBuy() {
		return buy;
	}

	public void setBuy(List<Double[]> buy) {
		this.buy = buy;
	}
	
}
