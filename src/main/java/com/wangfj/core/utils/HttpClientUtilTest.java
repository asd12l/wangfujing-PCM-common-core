package com.wangfj.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HttpClientUtilTest {
	@Test
	public void testSendHttpPost2() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("spuCode", "100000006");
//		String responseContent = HttpClientUtil2.getInstance()
//				.sendHttpPost("http://10.6.2.48:8046/pcm-outer-sdc/product/getProYeInfoBySpuCode.htm", JsonUtil.getJSONString(map));
		String response=HttpUtil2.doPost("http://10.6.2.48:8046/pcm-outer-sdc/product/getProYeInfoBySpuCode.htm", JsonUtil.getJSONString(map));
//		String response=HttpUtil.doPost("http://10.6.2.48:8046/pcm-outer-sdc/product/getProYeInfoBySpuCode.htm", JsonUtil.getJSONString(map));
		System.out.println("reponse content:" + response);
	}
}
