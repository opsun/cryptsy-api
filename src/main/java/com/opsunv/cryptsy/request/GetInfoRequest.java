package com.opsunv.cryptsy.request;

import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.GetInfoResponse;

/**
 * Authenticated API <b>getinfo</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class GetInfoRequest extends CryptsyRequest<GetInfoResponse> {

	@Override
	public String getMethod() {
		return "getinfo";
	}

}
