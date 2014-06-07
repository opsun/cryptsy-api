package com.opsunv.cryptsy.request;

import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.MarketDataV2Response;

/**
 * public API <b>marketdatav2</b><br>
 * http://pubapi.cryptsy.com/api.php?method=marketdatav2
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class MarketDataV2Request extends CryptsyRequest<MarketDataV2Response> {

	@Override
	public String getMethod() {
		return "marketdatav2";
	}
	
	@Override
	public boolean auth() {
		return false;
	}


}
