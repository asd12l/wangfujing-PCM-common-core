package com.wangfj.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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

	/**
	 * 执行一个HTTP POST请求
	 * @Methods Name doPost
	 * @Create In 2016年10月19日 By kongqf
	 * @param url 请求的URL地址
	 * @param json 请求的查询参数,可以为null
	 * @return String 返回请求响应的HTML
	 */
	public static String doPost(String url, String json) {
		return doPost(url, json, "application/json");
	}

	/**
	 * 执行一个HTTP POST请求
	 * @Methods Name doPost
	 * @Create In 2016年10月19日 By kongqf
	 * @param url 请求的URL地址
	 * @param json 请求的查询参数,可以为null
	 * @param contentType ContentType
	 * @return String 返回请求响应的HTML
	 */
	public static String doPost(String url, String json, String contentType) {
		LOGGER.debug("doPost url is {},parajson is {}", new Object[] { url, json });
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		try {
			// 设置参数
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			stringEntity.setContentType(contentType);
			httpPost.setEntity(stringEntity);
			// 设置请求配置
			httpPost.setConfig(requestConfig);
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			// 执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			LOGGER.error("url is {},parajson is {},Exception is {}",
					new Object[] { url, json, e.getMessage() });
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
		LOGGER.debug("url is {},parajsonjson is {},response is {}",
				new Object[] { url, json, responseContent });
		return responseContent;
	}

	/**
	 * 发送Get请求工具方法
	 * @Methods Name HttpGet
	 * @Create In 2016年10月19日 By kongqf
	 * @param url
	 * @param method
	 * @param paramMap
	 * @return String
	 */
	public static String HttpGet(String url, String method, Map paramMap) {
		LOGGER.debug("HttpGet url is {},method is {},paramMap is {}",
				new Object[] { url, method, paramMap });
		// 设置编码格式
		String encoding = "UTF-8";
		String webUrl = url;
		if (StringUtils.isNotEmpty(method)) {
			webUrl = url + "/" + method;
		}
		if (encoding == null || "".equals(encoding))
			encoding = "UTF-8";
		String queryString = createLinkString(paramMap);
		webUrl = webUrl + "?" + queryString;
		HttpGet httpGet = new HttpGet(webUrl);// 创建get请求

		return sendHttpGet(httpGet);
	}

	/**
	 * 发送Get请求
	 * 
	 * @param httpGet
	 * @return
	 */
	private static String sendHttpGet(HttpGet httpGet) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpGet.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {
		String prestr = "";
		if (params != null && params.size() > 0) {
			List<String> keys = new ArrayList<String>(params.keySet());
			Collections.sort(keys);
			for (int i = 0; i < keys.size(); i++) {
				String key = keys.get(i);
				String value = params.get(key);

				if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
					prestr = prestr + key + "=" + value;
				} else {
					prestr = prestr + key + "=" + value + "&";
				}
			}
		}

		return prestr;
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
