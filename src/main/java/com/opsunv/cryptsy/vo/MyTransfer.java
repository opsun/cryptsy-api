package com.opsunv.cryptsy.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MyTransfer {
	//Currency being transfered
	private String currency;
	
	//Datetime the transfer was requested/initiated
	@JsonProperty("request_timestamp")
	private Date requestTimestamp;
	
	//Datetime of processed transfer
	@JsonProperty("processed_timestamp")
	private Date processedTimestamp;
	
	//Indicator if transfer has been processed (1) or not (0)
	private int processed;
	
	//Username sending transfer
	private String from;
	
	//Username receiving transfer
	private String to;
	
	//Quantity being transfered
	private double quantity;
	
	//Indicates if transfer is incoming or outgoing (in/out)
	private String direction;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public Date getProcessedTimestamp() {
		return processedTimestamp;
	}

	public void setProcessedTimestamp(Date processedTimestamp) {
		this.processedTimestamp = processedTimestamp;
	}

	public int getProcessed() {
		return processed;
	}

	public void setProcessed(int processed) {
		this.processed = processed;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
