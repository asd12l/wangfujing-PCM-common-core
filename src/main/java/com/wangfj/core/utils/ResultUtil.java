package com.wangfj.core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 格式化响应信息的工具类
 * 
 * @author kongxiangshuai
 * @date 2013-12-12
 * @modify
 */
public class ResultUtil {
	// /**
	// * 返回通用结果
	// * @Methods Name creResult
	// * @Create In 2015-8-7 By liuhp
	// * @param result
	// * @return Map<String,Object>
	// */
	// public static Map<String, Object> creResult(ResultObject result) {
	// Map<String, Object> resultMap = new HashMap<String, Object>();
	// resultMap.put("success", result.getSuccess());
	// resultMap.put("errorCode",result.getErrCode());
	// resultMap.put("errMsg", result.getErrMsg());
	// resultMap.put("obj", result.getObj());
	// return resultMap;
	// }

//	/**
//	 * 创建page类型的成功结果
//	 * 
//	 * @Methods Name crePageSucResult
//	 * @Create In 2015-8-8 By liuhp
//	 * @param page
//	 * @return Map<String,Object>
//	 */
//	@SuppressWarnings("rawtypes")
//	public static Map<String, Object> crePageSucResult(Page page) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("success", "true");
//		resultMap.put("page", page);
//		return resultMap;
//	}
//
//	/**
//	 * 返回单个对象类型的成功结果
//	 * 
//	 * @Methods Name creObjSucResult
//	 * @Create In 2015-8-8 By liuhp
//	 * @param obj
//	 * @return Map<String,Object>
//	 */
//	public static Map<String, Object> creObjSucResult(Object obj) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("success", "true");
//		resultMap.put("obj", obj);
//		return resultMap;
//	}
//
//	/**
//	 * 返回List类型的成功结果
//	 * 
//	 * @Methods Name eListSucResult
//	 * @Create In 2014年12月12日 By wangfei
//	 * @param list
//	 * @return Map<String,Object>
//	 */
//	public static Map<String, Object> creListSucResult(List list) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("list", list);
//		resultMap.put("success", "true");
//		return resultMap;
//	}

//	/**
//	 * 返回通用的成功 结果
//	 * 
//	 * @Methods Name creComSucResult
//	 * @Create In 2015-8-8 By liuhp
//	 * @return Map<String,Object>
//	 */
//	public static Map<String, Object> creComSucResult() {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("success", "true");
//		return resultMap;
//	}

	/**
	 * 返回通用的成功 结果
	 * 
	 * @Methods Name creComSucResult
	 * @Create In 2015-8-8 By liuhp
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> creComSucResult(Object object) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", "true");
		resultMap.put("data",object);
		return resultMap;
	}

	/**
	 * 返回通用的错误类型
	 * 
	 * @Methods Name creComErrorResult
	 * @Create In 2015-8-8 By liuhp
	 * @param message
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> creComErrorResult(String errorCode, String message) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> errMap = new HashMap<String, Object>();
		resultMap.put("success", "false");
		errMap.put("errorCode", errorCode);
		errMap.put("errorMsg", message);
		resultMap.put("data", errMap);
		return resultMap;
	}
}
