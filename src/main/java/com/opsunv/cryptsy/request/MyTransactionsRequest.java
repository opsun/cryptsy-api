package com.opsunv.cryptsy.request;

import com.opsunv.cryptsy.CryptsyRequest;
import com.opsunv.cryptsy.response.MyTransactionsResponse;

/**
 * Authenticated API <b>mytransactions</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class MyTransactionsRequest extends CryptsyRequest<MyTransactionsResponse>{

	@Override
	public String getMethod() {
		return "mytransactions";
	}

}
