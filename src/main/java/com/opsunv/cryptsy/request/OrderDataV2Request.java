package com.opsunv.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.OrderDataV2Response;
import com.opsunv.cryptsy.utils.ParseUtils;

/**
 * public API <b>orderdatav2</b><br>
 * http://pubapi.cryptsy.com/api.php?method=orderdatav2
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class OrderDataV2Request extends CryptsyRequest<OrderDataV2Response> {

	@Override
	public String getMethod() {
		return "orderdatav2";
	}
	
	@Override
	public boolean auth() {
		return false;
	}
	
	@Override
	public OrderDataV2Response parse(JsonNode json) {
		JsonNode rs = ParseUtils.pack(json, "return");
		return super.parse(rs);
	}
}
