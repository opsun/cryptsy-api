package com.opsunv.cryptsy.request;

import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.AllMyOrdersResponse;

/**
 * Authenticated API <b>allmyorders</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyOrdersRequest extends CryptsyRequest<AllMyOrdersResponse>{

	@Override
	public String getMethod() {
		return "allmyorders";
	}

}
