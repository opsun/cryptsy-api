package com.opsunv.cryptsy.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opsunv.cryptsy.vo.ActiveMarket;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class GetMarketsResponse {
	
	@JsonProperty("return")
	private List<ActiveMarket> activeMarkets = new ArrayList<ActiveMarket>();

	public List<ActiveMarket> getActiveMarkets() {
		return activeMarkets;
	}

	public void setActiveMarkets(List<ActiveMarket> activeMarkets) {
		this.activeMarkets = activeMarkets;
	}
	
	/**
	 * get market by market id
	 * @param marketId
	 * @return
	 */
	public ActiveMarket getActiveMarket(int marketId){
		if(activeMarkets!=null){
			for(ActiveMarket am : activeMarkets){
				if(am.getMarketId()==marketId){
					return am;
				}
			}	
		}
		
		return null;
	}
	
	/**
	 * get market by label
	 * @param label
	 * @return
	 * @throws NullPointerException if label is null
	 */
	public ActiveMarket getActiveMarket(String label){
		if(label==null){
			throw new NullPointerException();
		}
		
		if(activeMarkets!=null){
			for(ActiveMarket am : activeMarkets){
				if(label.equalsIgnoreCase(am.getLabel())){
					return am;
				}
			}	
		}
		
		return null;
	}
	
}
