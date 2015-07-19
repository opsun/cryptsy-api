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
		this(publicKey,privateKey,null,null);
	}
	
	public MixedCryptsyApi(String publicKey,String privateKey,String publicApiUrl,String privateApiUrl) {
		pubApi = new PublicCryptsyApi(publicApiUrl);
		authApi = new AuthenticatedCryptsyAPI(publicKey,privateKey,privateApiUrl);
	}

	@Override
	public <T> T execute(CryptsyRequest<T> request) throws ApiException,IOException {
		return request.auth()?authApi.execute(request):pubApi.execute(request);
	}


}
