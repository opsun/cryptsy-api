package com.opsunv.cryptsy.vo;

import java.util.Date;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class TradeOrder extends Order{
	private int id;
	
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
