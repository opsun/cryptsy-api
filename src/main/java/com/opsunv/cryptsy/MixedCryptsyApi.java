package com.opsunv.cryptsy;

import java.io.IOException;

/**
 * wrap Public an Authenticated API
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MixedCryptsyApi implements CryptsyApi{
	private CryptsyApi pubApi;
	
	private CryptsyApi authApi;
	
	public MixedCryptsyApi(String publicKey,String privateKey) {
		pubApi = new PublicCryptsyApi();
		authApi = new AuthenticatedCryptsyAPI(publicKey,privateKey);
	} 

	@Override
	public <T> T execute(CryptsyRequest<T> request) throws ApiException,IOException {
		return request.auth()?authApi.execute(request):pubApi.execute(request);
	}


}
