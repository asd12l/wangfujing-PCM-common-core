package com.wangfj.core.handler;

import org.apache.commons.lang.StringUtils;

import com.wangfj.core.constants.HttpMethod;
import com.wangfj.core.utils.HttpUtil;

/**
 * 
 * @author wangchaochao
 *
 */
public abstract class HttpSynHandler extends AbstractSynHandler {

	public boolean send(Object body) {
		if(body == null){
			return false;
		}
		String sBody = (String)body;
		if(StringUtils.isBlank(sBody)){
			return false;
		}
		if(HttpMethod.POST.equals(getMethod())){
			HttpUtil.doPost(getUrl(), (String)body);
		}else{
			//TODO doGet
		}
		return true;
	}

	public abstract String getUrl();
	
	public String getMethod(){
		return HttpMethod.POST;
	}
}
