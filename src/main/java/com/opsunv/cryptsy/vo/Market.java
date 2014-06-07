package com.opsunv.cryptsy.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class Market {
	
	@JsonProperty("marketid")
	private int marketId;
	
	private String label;
	
	@JsonProperty("primaryname")
	private String primaryName;
	
	@JsonProperty("primarycode")
	private String primaryCode;
	
	@JsonProperty("secondaryname")
	private String secondaryName;
	
	@JsonProperty("secondarycode")
	private String secondaryCode;
	
	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getPrimaryCode() {
		return primaryCode;
	}

	public void setPrimaryCode(String primaryCode) {
		this.primaryCode = primaryCode;
	}

	public String getSecondaryName() {
		return secondaryName;
	}

	public void setSecondaryName(String secondaryName) {
		this.secondaryName = secondaryName;
	}

	public String getSecondaryCode() {
		return secondaryCode;
	}

	public void setSecondaryCode(String secondaryCode) {
		this.secondaryCode = secondaryCode;
	}

}
