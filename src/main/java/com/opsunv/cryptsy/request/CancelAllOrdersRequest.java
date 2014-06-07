package com.opsunv.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsunv.cryptsy.CryptsyRequest;

/**
 * Authenticated API <b>cancelallorders</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class CancelAllOrdersRequest extends CryptsyRequest<Boolean> {

	@Override
	public String getMethod() {
		return "cancelallorders";
	}
	
	@Override
	public Boolean parse(JsonNode json) {
		return true;
	}

}
