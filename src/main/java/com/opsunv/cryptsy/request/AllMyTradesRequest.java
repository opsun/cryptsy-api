package com.opsunv.cryptsy.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.AllMyTradesResponse;
import com.opsunv.cryptsy.utils.Assert;
import com.opsunv.cryptsy.utils.ParseUtils;

/**
 * Authenticated API <b>allmytrades</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyTradesRequest extends CryptsyRequest<AllMyTradesResponse>{
	//Starting date for query (format: yyyy-mm-dd)
	private String startDate;
	
	//Ending date for query (format: yyyy-mm-dd)
	private String endDate;
	
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Starting date for query (format: yyyy-mm-dd)
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * Ending date for query (format: yyyy-mm-dd)
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String getMethod() {
		return "allmytrades";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		if(!Assert.isEmpty(startDate)){
			map.put("startdate", startDate);
		}
		
		if(!Assert.isEmpty(endDate)){
			map.put("enddate", endDate);
		}
		
		return super.getParams();
	}
	
	@Override
	public AllMyTradesResponse parse(JsonNode json) {
		json = ParseUtils.pack(json, "return");
		return super.parse(json);
	}

}
