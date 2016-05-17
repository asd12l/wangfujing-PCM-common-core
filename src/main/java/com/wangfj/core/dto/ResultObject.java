package com.wangfj.core.dto;

/**
 * 返回结果实体对象
 * @Class Name ResultObject
 * @Author liuhp
 * @Create In 2015-8-7
 */

public class ResultObject {
	private Boolean success;//返回成功/失败
	private String errCode;//错误编码
	private String errMsg;//错误信息
	private Object obj;//返回对象（Page,list,object）
	
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "ResultObject [success=" + success + ", errCode=" + errCode + ", errMsg=" + errMsg
				+ ", obj=" + obj + "]";
	}
	
}
