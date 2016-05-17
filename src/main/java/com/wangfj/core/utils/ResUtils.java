package com.wangfj.core.utils;

import com.wangfj.core.constants.ComErrorCodeConstants;

public class ResUtils {
	
	public static  boolean checkFail(String json){
		net.sf.json.JSONObject jo=net.sf.json.JSONObject.fromObject(json);
		String rescode=(String)jo.get("resCode");
		if(ComErrorCodeConstants.ErrorCode.SYSTEM_SUCCESS.getErrorCode().equals(rescode)){
			return true;
		}
		return false;
	}
}
