package com.opsunv.cryptsy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class WebUtils {
	
	public final static String METHOD_GET = "GET";
	
	public final static String METHOD_POST = "POST";
	
	private static class DefaultTrustManager implements X509TrustManager {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
	}
	
	private static HttpURLConnection getConnection(URL url, String method, Map<String, String> headerMap) throws IOException {
		HttpURLConnection conn = null;
		if ("https".equals(url.getProtocol())) {
			SSLContext ctx = null;
			try {
				ctx = SSLContext.getInstance("TLS");
				ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
			} catch (Exception e) {
				throw new IOException(e);
			}
			HttpsURLConnection connHttps = (HttpsURLConnection) url.openConnection();
			connHttps.setSSLSocketFactory(ctx.getSocketFactory());
			connHttps.setHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
			conn = connHttps;
		} else {
			conn = (HttpURLConnection) url.openConnection();
		}

		conn.setRequestMethod(method);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
		conn.setRequestProperty("User-Agent", "cryptsy-java-api");
		conn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
		
		if(METHOD_POST.equalsIgnoreCase(method)){
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		}
		
		if (headerMap != null) {
			for (Map.Entry<String, String> entry : headerMap.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		
		conn.setConnectTimeout(3000);
		conn.setReadTimeout(15000);
		
		return conn;
	}
	
	public static String doGet(String url, Map<String, String> params) throws IOException {
		HttpURLConnection conn = null;
		String rsp = null;

		try {
			String query = buildQuery(params);
			try {
				conn = getConnection(buildGetUrl(url, query), METHOD_GET,null);
			} catch (IOException e) {
				throw e;
			}

			try {
				rsp = getResponseAsString(conn);
			} catch (IOException e) {
				throw e;
			}

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		return rsp;
	}
	
	public static String doPost(String url, Map<String, String> params,Map<String, String> headerMap) throws IOException {
		HttpURLConnection conn = null;
		OutputStream out = null;
		String rsp = null;
		try {
			conn = getConnection(new URL(url), METHOD_POST,headerMap);
			String query = buildQuery(params);
			
			out = conn.getOutputStream();
			out.write(query.getBytes());
			
			rsp = getResponseAsString(conn);
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}

		return rsp;
	}
	
	public static String buildQuery(Map<String, String> params) throws IOException {
		if (params == null || params.isEmpty()) {
			return null;
		}

		StringBuilder query = new StringBuilder();
		boolean hasParam = false;
		for (Entry<String, String> entry : params.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			if (!Assert.isEmpty(name)) {
				if (hasParam) {
					query.append("&");
				} else {
					hasParam = true;
				}

				query.append(name).append("=").append(value);
			}
		}

		return query.toString();
	}
	
	private static URL buildGetUrl(String strUrl, String query) throws IOException {
		URL url = new URL(strUrl);
		if (Assert.isEmpty(query)) {
			return url;
		}

		if (Assert.isEmpty(url.getQuery())) {
			if (strUrl.endsWith("?")) {
				strUrl = strUrl + query;
			} else {
				strUrl = strUrl + "?" + query;
			}
		} else {
			if (strUrl.endsWith("&")) {
				strUrl = strUrl + query;
			} else {
				strUrl = strUrl + "&" + query;
			}
		}

		return new URL(strUrl);
	}
	
	protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
		InputStream es = conn.getErrorStream();
		if (es == null) {
			String encoding = conn.getContentEncoding();
			InputStream in = conn.getInputStream();
			if("gzip".equalsIgnoreCase(encoding)){
				in = new GZIPInputStream(in);
			}else if("deflate".equalsIgnoreCase(encoding)){
				in = new DeflaterInputStream(in);
			}
			
			return getStreamAsString(in);
		} else {
			String msg = getStreamAsString(es);
			if (Assert.isEmpty(msg)) {
				throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
			} else {
				throw new IOException(msg);
			}
		}
	}
	
	private static String getStreamAsString(InputStream stream) throws IOException {
		try {
			Reader reader = new InputStreamReader(stream);
			StringBuilder response = new StringBuilder();

			final char[] buff = new char[1024];
			int read = 0;
			while ((read = reader.read(buff)) > 0) {
				response.append(buff, 0, read);
			}
			
			return response.toString();
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}
	
}
