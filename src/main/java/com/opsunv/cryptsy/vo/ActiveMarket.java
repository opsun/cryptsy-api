package com.opsunv.cryptsy.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class ActiveMarket{
	@JsonProperty("marketid")
	private int marketId;
	
	private String label;
	
	@JsonProperty("primary_currency_name")
	private String primaryCurrencyName;
	
	@JsonProperty("primary_currency_code")
	private String primaryCurrencyCode;
	
	@JsonProperty("secondary_currency_name")
	private String secondaryCurrencyName;
	
	@JsonProperty("secondary_currency_code")
	private String secondaryCurrencyCode;
	
	@JsonProperty("current_volume")
	private double currentVolume;
	
	@JsonProperty("current_volume_btc")
	private double currentVolumeBtc;
	
	@JsonProperty("current_volume_usd")
	private double currentVolumeUsd;
	
	@JsonProperty("last_trade")
	private double lastTrade;
	
	@JsonProperty("high_trade")
	private double highTrade;
	
	@JsonProperty("low_trade")
	private double lowTrade;
	
	private Date created;

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

	public String getPrimaryCurrencyName() {
		return primaryCurrencyName;
	}

	public void setPrimaryCurrencyName(String primaryCurrencyName) {
		this.primaryCurrencyName = primaryCurrencyName;
	}

	public String getPrimaryCurrencyCode() {
		return primaryCurrencyCode;
	}

	public void setPrimaryCurrencyCode(String primaryCurrencyCode) {
		this.primaryCurrencyCode = primaryCurrencyCode;
	}

	public String getSecondaryCurrencyName() {
		return secondaryCurrencyName;
	}

	public void setSecondaryCurrencyName(String secondaryCurrencyName) {
		this.secondaryCurrencyName = secondaryCurrencyName;
	}

	public String getSecondaryCurrencyCode() {
		return secondaryCurrencyCode;
	}

	public void setSecondaryCurrencyCode(String secondaryCurrencyCode) {
		this.secondaryCurrencyCode = secondaryCurrencyCode;
	}

	public double getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(double currentVolume) {
		this.currentVolume = currentVolume;
	}

	public double getCurrentVolumeBtc() {
		return currentVolumeBtc;
	}

	public void setCurrentVolumeBtc(double currentVolumeBtc) {
		this.currentVolumeBtc = currentVolumeBtc;
	}

	public double getCurrentVolumeUsd() {
		return currentVolumeUsd;
	}

	public void setCurrentVolumeUsd(double currentVolumeUsd) {
		this.currentVolumeUsd = currentVolumeUsd;
	}

	public double getLastTrade() {
		return lastTrade;
	}

	public void setLastTrade(double lastTrade) {
		this.lastTrade = lastTrade;
	}

	public double getHighTrade() {
		return highTrade;
	}

	public void setHighTrade(double highTrade) {
		this.highTrade = highTrade;
	}

	public double getLowTrade() {
		return lowTrade;
	}

	public void setLowTrade(double lowTrade) {
		this.lowTrade = lowTrade;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
