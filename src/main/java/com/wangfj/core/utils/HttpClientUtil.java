package com.wangfj.core.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * MQ
 * 
 * @Class Name HttpClientUtil
 * @Author wangsy
 * @Create In 2015年7月10日
 */
public class HttpClientUtil {

	// public static final String host = "127.0.0.1";
	// public static final int port = 8080;

	public static String doPost(String url, String param) {
		String result = null;
		try {
			HttpClient httpClient = new HttpClient();
			// httpClient.getHostConfiguration().setHost(host, port, "http");
			HttpMethod method = postMethod(url, param);
			httpClient.executeMethod(method);
			result = new String(method.getResponseBodyAsString().getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"success\":false,\"exception\":" + e.getMessage() + "}";
		}
		return result;
	}

	private static HttpMethod postMethod(String url, String param) throws IOException {
		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		NameValuePair[] params = { new NameValuePair("data", param) };
		post.setRequestBody(params);
		post.releaseConnection();
		return post;
	}

	@SuppressWarnings("deprecation")
	public static String SendMsg(String url, String param) {
		String result = null;
		try {
			HttpClient httpClient = new HttpClient();
			PostMethod post = new PostMethod(url);
			post.setRequestHeader("Content-Type", "charset=UTF-8");

			post.setRequestBody(param);
			post.releaseConnection();
			httpClient.executeMethod(post);
			result = new String(post.getResponseBodyAsString().getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"success\":false,\"exception\":" + e.getMessage() + "}";
		}
		return result;

	}
}
