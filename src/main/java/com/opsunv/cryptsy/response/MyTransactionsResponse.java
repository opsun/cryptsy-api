package com.opsunv.cryptsy.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.MyTransaction;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MyTransactionsResponse {
	@JsonProperty("return")
	private List<MyTransaction> transactions = new ArrayList<MyTransaction>();

	public List<MyTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<MyTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
