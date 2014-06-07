package com.opsunv.cryptsy;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsunv.cryptsy.utils.Assert;
import com.opsunv.cryptsy.utils.WebUtils;

/**
 * An implementation of the Cryptsy Authenticated API
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class AuthenticatedCryptsyAPI extends CryptsyApi{
	private final static String API_URL = "https://www.cryptsy.com/api";
	
	private String publicKey;
	
	private String privateKey;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * get public key and private key from https://www.cryptsy.com/users/settings
	 * @param publicKey
	 * @param privateKey
	 */
	public AuthenticatedCryptsyAPI(String publicKey, String privateKey) {
		if(Assert.isEmpty(publicKey,privateKey)){
			throw new IllegalArgumentException("both a public key and private key cannot be empty!");
		}
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}
	
	@Override
	protected JsonNode query(String method,Map<String, String> params) throws IOException{
		//timestamp
		String nonce = System.currentTimeMillis()+"";
		
		Map<String, String> data = new TreeMap<String, String>();
		if(params!=null){
			data.putAll(params);
		}
		data.put("method", method);
		data.put("nonce", nonce);
		
		StringBuilder sb = new StringBuilder();
		for(Entry<String, String> entry : data.entrySet()){
			sb.append("&"+entry.getKey()+"="+entry.getValue());
		}
		String sign = null;
		try {
			sign = computeSignature(sb.toString().substring(1));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Map<String, String> header = new HashMap<String, String>();
		header.put("Key", this.publicKey);
		header.put("Sign", sign);
		
		return objectMapper.readTree(WebUtils.doPost(API_URL, data, header));
	}
	
	/**
	 * signed by a secret key according to HMAC-SHA512 method.
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 */
	private String computeSignature(String str) throws InvalidKeyException,NoSuchAlgorithmException {
	    SecretKey secretKey = null;
	    byte[] keyBytes = privateKey.getBytes();
	    secretKey = new SecretKeySpec(keyBytes, "HmacSHA512");
	    
	    Mac mac = Mac.getInstance("HmacSHA512");
	    mac.init(secretKey);
	   
	    byte[] text = str.getBytes();
	    return Hex.encodeHexString(mac.doFinal(text));
	}

}
