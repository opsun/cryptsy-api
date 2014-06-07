package com.opsunv.cryptsy;

import com.opsunv.cryptsy.request.MarketDataV2Request;
import com.opsunv.cryptsy.request.OrderDataV2Request;
import com.opsunv.cryptsy.request.SingleMarketDataRequest;
import com.opsunv.cryptsy.request.SingleOrderDataRequest;
import com.opsunv.cryptsy.response.MarketDataV2Response;
import com.opsunv.cryptsy.response.OrderDataV2Response;
import com.opsunv.cryptsy.response.SingleMarketDataResponse;
import com.opsunv.cryptsy.response.SingleOrderDataResponse;

import junit.framework.TestCase;

public class PublicApiTest extends TestCase {
	private PublicCryptsyApi api = new PublicCryptsyApi();
	
	public void testMarketdatav2() throws Exception{
		MarketDataV2Response response = api.execute(new MarketDataV2Request());
		System.out.println(response.getMarketData().size());
	}
	
	public void testOrderdatav2() throws Exception{
		OrderDataV2Response response = api.execute(new OrderDataV2Request());
		System.out.println(response.getOrderData().size());
	}
	
	public void testSinglemarketdata() throws Exception{
		SingleMarketDataRequest request = new SingleMarketDataRequest();
		request.setMarketId(94);
		SingleMarketDataResponse response = api.execute(request);
		System.out.println(response.getLabel());
	}
	
	public void testSingleorderdata() throws Exception{
		SingleOrderDataRequest request = new SingleOrderDataRequest();
		request.setMarketId(94);
		SingleOrderDataResponse response = api.execute(request);
		System.out.println(response.getLabel());
	}
}