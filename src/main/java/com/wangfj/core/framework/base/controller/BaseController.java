package com.wangfj.core.framework.base.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.bson.util.StringRangeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wangfj.core.constants.ComErrorCodeConstants;
import com.wangfj.core.constants.ComErrorCodeConstants.ExcptionTypeCode;
import com.wangfj.core.constants.ErrorCodeConstants.ErrorCode;
import com.wangfj.core.framework.exception.BleException;
import com.wangfj.core.utils.PropertyConfigurer;
import com.wangfj.core.utils.ResultUtil;
import com.wfj.exception.client.common.ErrorLevel;
import com.wfj.exception.client.handler.EcMapperHandler;
import com.wfj.exception.client.handler.MyExceptionHandler;
import com.wfj.exception.client.util.PropertiesLoad;
import com.wfj.exception.client.util.StringUtils;
import com.wfj.exception.client.util.SystemBootstrap;

/**
 * Controller基类
 * 
 * @Author wangfei, zhangjie
 * @Create In 2014年10月8日
 */

public class BaseController {

	public static final String VIEW = "view";
	public static final String LIST = "list";
	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String MESSAGES = "messages";
	public static final String CONTENT = "content";

	static Logger loger = LoggerFactory.getLogger(BaseController.class);

	private static Gson GSON = new GsonBuilder()
			.enableComplexMapKeySerialization()
			.setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	/**
	 * AJAX输出，返回null
	 * 
	 * @param content
	 * @param type
	 * @return
	 */
	public String ajax(HttpServletResponse response, String content, String type) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			loger.error("IOException:", e);
		}
		return null;
	}

	/**
	 * AJAX输出文本，返回null
	 * 
	 * @param text
	 * @return
	 */
	public String ajaxText(HttpServletResponse response, String text) {
		return ajax(response, text, "text/plain");
	}

	/**
	 * AJAX输出HTML，返回null
	 * 
	 * @param html
	 * @return
	 */
	public String ajaxHtml(HttpServletResponse response, String html) {
		return ajax(response, html, "text/html");
	}

	/**
	 * AJAX输出XML，返回null
	 * 
	 * @param xml
	 * @return
	 */
	public String ajaxXml(HttpServletResponse response, String xml) {
		return ajax(response, xml, "text/xml");
	}

	/**
	 * 根据字符串输出JSON，返回null
	 * 
	 * @param jsonString
	 * @return
	 */
	public String ajaxJson(HttpServletResponse response, String jsonString) {
		return ajax(response, jsonString, "text/html");
	}

	/**
	 * 根据Map输出JSON，返回null
	 * 
	 * @param jsonMap
	 * @return
	 */
	public String ajaxJson(HttpServletResponse response,
			Map<String, String> jsonMap) {
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 输出JSON警告消息，返回null
	 * 
	 * @param message
	 * @return
	 */
	public String ajaxJsonWarnMessage(HttpServletResponse response,
			String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 输出JSON警告消息，返回null
	 * 
	 * @param messages
	 * @return
	 */
	public String ajaxJsonWarnMessages(HttpServletResponse response,
			List<String> messages) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGES, messages);
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 输出JSON成功消息，返回null
	 * 
	 * @param message
	 * @return
	 */
	public String ajaxJsonSuccessMessage(HttpServletResponse response,
			String message) {

		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, message);
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 输出JSON成功消息，返回null
	 * 
	 * @param messages
	 * @return
	 */
	public String ajaxJsonSuccessMessages(HttpServletResponse response,
			List<String> messages) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGES, messages);
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 输出JSON错误消息，返回null
	 * 
	 * @param message
	 * @return
	 */
	public String ajaxJsonErrorMessage(HttpServletResponse response,
			String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, message);
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 输出JSON错误消息，返回null
	 * 
	 * @param messages
	 * @return
	 */
	public String ajaxJsonErrorMessages(HttpServletResponse response,
			List<String> messages) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGES, messages);
		return ajax(response, GSON.toJson(jsonMap), "text/html");
	}

	/**
	 * 设置页面不缓存
	 */
	public void setResponseNoCache(HttpServletResponse response) {
		response.setHeader("progma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
	}

	/**
	 * 根据Object输出JSON字符串
	 */
	public String getJson(Object jsonObject) {
		return GSON.toJson(jsonObject);
	}

	/**
	 * 根据字符串输出JSON，返回null
	 * 
	 * @param jsonString
	 * @return
	 */
	public String ajaxJsonCache(HttpServletResponse response,
			String jsonString, String cacheTime) {
		return ajaxCache(response, jsonString, "text/html", cacheTime);
	}

	/**
	 * AJAX输出，返回null
	 * 
	 * @param content
	 * @param type
	 * @return
	 */
	public String ajaxCache(HttpServletResponse response, String content,
			String type, String cacheTime) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			setCache(response, cacheTime);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			loger.error(e.getMessage());
		}
		return null;
	}

	public void setCache(HttpServletResponse response, String cacheTime) {
		long now = System.currentTimeMillis();
		long cacheTimeLong = Long.parseLong(cacheTime);
		response.setDateHeader("Expires", now + cacheTimeLong);
		response.setDateHeader("Last-Modified", now - (now % cacheTimeLong));
		response.setHeader("Cache-Control", "max-age=" + cacheTime);
		response.setHeader("Pragma", "Pragma");
	}

	/**
	 * 公共校验参数方法
	 * 
	 * @Methods Name validateParas
	 * @Create In 2014年10月8日 By wangfei
	 * @param parametersBindingResult
	 * @param map
	 * @return boolean
	 */
	protected boolean validateParas(BindingResult parametersBindingResult,
			Map<String, Object> map) {
		if (parametersBindingResult.hasErrors()) {
			List<FieldError> fes = parametersBindingResult.getFieldErrors();
			String checkMsg = fes.get(0).getDefaultMessage();
			map.put("success", false);
			map.put("errorCode", ComErrorCodeConstants.ErrorCode.VALIDATE_ERROR
					.getErrorCode());
			map.put("msg", checkMsg);
			return false;
		}
		return true;
	}

	/**
	 * spring API请求格式通用处理
	 * 
	 * @Methods Name handleHttpMessageConversionException
	 * @Create In 2014年10月29日 By wangfei
	 * @param error
	 * @return String
	 */
	@ExceptionHandler({ BleException.class, BindException.class,
			MethodArgumentNotValidException.class })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	protected Map<String, Object> handleBusException(Exception ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ex instanceof BindException) {
			BindingResult result = ((BindException) ex).getBindingResult();
			List<FieldError> fes = result.getFieldErrors();
			String checkMsg = fes.get(0).getDefaultMessage();
			map =ResultUtil.creComErrorResult(ComErrorCodeConstants.ErrorCode.VALIDATE_ERROR
					.getErrorCode(),checkMsg);
		}
		// 判断异常类型
		else if (ex instanceof MethodArgumentNotValidException) {
			// org.springframework.validation.BindException
			BindingResult result = ((MethodArgumentNotValidException) ex)
					.getBindingResult();
			List<FieldError> fes = result.getFieldErrors();
			String checkMsg = fes.get(0).getDefaultMessage();
			map =ResultUtil.creComErrorResult(ComErrorCodeConstants.ErrorCode.VALIDATE_ERROR
					.getErrorCode(),checkMsg);
		} else {
			loger.info("throw BleException!cause:{}", ex.getStackTrace());
			sendException(ex);
			String systemErrorCode ="";
      if(StringUtils.isNotBlank(((BleException)ex).getCode())){
        systemErrorCode = ((BleException)ex).getCode().replaceFirst("00",PropertyConfigurer.getContextProperty("system.excption.code"));
      }
			map =ResultUtil.creComErrorResult(systemErrorCode,((BleException) ex).getMessage());
		}
		return map;
	}

	/**
	 * spring API请求格式通用处理
	 * 
	 * @Methods Name handleHttpMessageConversionException
	 * @Create In 2014年10月29日 By wangfei
	 * @param error
	 * @return String
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	protected Map<String, Object> handleCommonException(Exception ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		loger.error("throw Exception!cause:{}", ex.getStackTrace());
		if(ex instanceof BleException){
		  String systemErrorCode ="";
		  if(StringUtils.isNotBlank(((BleException)ex).getCode())){
		    systemErrorCode = ((BleException)ex).getCode().replaceFirst("00",PropertyConfigurer.getContextProperty("system.excption.code"));
		  }
		  map =ResultUtil.creComErrorResult(systemErrorCode,((BleException) ex).getMessage());
	    sendException(ex);
		}else{
		  String systemErrorCode =ComErrorCodeConstants.ErrorCode.APPLICATION_OPER_ERROR.getErrorCode()
		      .replaceFirst("00",PropertyConfigurer.getContextProperty("system.excption.code"));
      map =ResultUtil.creComErrorResult(systemErrorCode,ex.getMessage());
		}
		return map;
	}
	public static void sendException(Exception e){
		MyExceptionHandler handler = new MyExceptionHandler();
//	    PropertiesLoad.putProperties("mq_server", PropertyConfigurer.getContextProperty("system.excption.mq.url"));
//	    PropertiesLoad.putProperties("mq_dest_url", PropertyConfigurer.getContextProperty("system.excption.dest.url"));
//	    PropertiesLoad.putProperties("client.exception.sys_code", PropertyConfigurer.getContextProperty("system.excption.code"));
	    PropertiesLoad.putProperties("exception.brokerList", PropertyConfigurer.getContextProperty("exception.brokerList"));
      PropertiesLoad.putProperties("exception.topic", PropertyConfigurer.getContextProperty("exception.topic"));
      PropertiesLoad.putProperties("exception.sysCode", PropertyConfigurer.getContextProperty("system.excption.code"));
	    String[] strArr=splitCode(((BleException) e).getCode());
	    boolean flag = ErrorCode.vaildErrorCode(((BleException) e).getCode());
	    handler.putException(strArr[0], ExcptionTypeCode.getErrorCodeName(strArr[0]), strArr[1], ((BleException) e).getMessage(), e, flag?ErrorLevel.ERROR.getCode():ErrorLevel.WARING.getCode());
	}
	public static void sendException(BleException e){
	  MyExceptionHandler handler = new MyExceptionHandler();
//	    PropertiesLoad.putProperties("mq_server", PropertyConfigurer.getContextProperty("system.excption.mq.url"));
//	    PropertiesLoad.putProperties("mq_dest_url", PropertyConfigurer.getContextProperty("system.excption.dest.url"));
//	    PropertiesLoad.putProperties("client.exception.sys_code", PropertyConfigurer.getContextProperty("system.excption.code"));
	  PropertiesLoad.putProperties("exception.brokerList", PropertyConfigurer.getContextProperty("exception.brokerList"));
	  PropertiesLoad.putProperties("exception.topic", PropertyConfigurer.getContextProperty("exception.topic"));
	  PropertiesLoad.putProperties("exception.sysCode", PropertyConfigurer.getContextProperty("system.excption.code"));
	  String[] strArr=splitCode(((BleException) e).getCode());
	  boolean flag = ErrorCode.vaildErrorCode(((BleException) e).getCode());
	  handler.putException(strArr[0], ExcptionTypeCode.getErrorCodeName(strArr[0]), strArr[1],
	      ((BleException) e).getMessage(), e, flag?ErrorLevel.ERROR.getCode():ErrorLevel.WARING.getCode());
	}
	public static String[] splitCode(String code){
		String bussCode = code.substring(2,5);
		String errorCode = code.substring(5);
		if(errorCode.length()<3){
			errorCode =errorCode+"0";
		}
		String[] codeArr=new String[2];
		codeArr[0]=bussCode;
		codeArr[1]=errorCode;
		return codeArr;
	}
}
