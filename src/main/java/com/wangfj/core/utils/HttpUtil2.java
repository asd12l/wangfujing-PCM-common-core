package com.wangfj.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class HttpUtil2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil2.class);
	private static final RequestConfig requestConfig;

	static {
		requestConfig = RequestConfig.custom().setSocketTimeout(70000).setConnectTimeout(50000)
				.setConnectionRequestTimeout(15000).build();
	}

	public static String doPost(String url, String json) {
		LOGGER.debug("doPost url is {},parajson is {}", new Object[] { url, json });
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		try {
			// 设置参数
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
		} catch (Exception e) {
			LOGGER.error("url is {},parajson is {},Exception is {}",
					new Object[] { url, json, e.getMessage() });
		}
		return sendHttpPost(httpPost);
	}

	private static String sendHttpPost(HttpPost httpPost) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			// 设置请求配置
			httpPost.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
			LOGGER.debug("url is {},parajsonjson is {},response is {}",
					new Object[] { httpPost.getURI(),response.getParams(), responseContent });
		} catch (Exception e) {
			
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	/**
	 * 请求数据转换成JSONObject
	 * 
	 * @Methods Name HttpGetRequest
	 * @Create In 2015年9月9日 By kongqf
	 * @param request
	 * @param c
	 * @return
	 * @throws IOException
	 *             JSONObject
	 */
	public static JSONObject HttpGetRequest(HttpServletRequest request) throws IOException {
		StringBuilder sbParaInfo = new StringBuilder();
		BufferedReader br = new BufferedReader(
				new InputStreamReader((ServletInputStream) request.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			sbParaInfo.append(line);
		}
		JSONObject jsono = JSONObject.fromObject(sbParaInfo.toString());
		return jsono;
	}
}
