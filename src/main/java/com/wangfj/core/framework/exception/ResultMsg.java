package com.wangfj.core.framework.exception;

import com.wangfj.core.framework.base.dto.BaseDto;

public class ResultMsg extends BaseDto {
	private String orderDetailNo;
	private String msgCode;
	private String comGoodsSid;
	private String msg;
	private String goodsSid;
	private String goodsName;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsSid() {
		return goodsSid;
	}

	public void setGoodsSid(String goodsSid) {
		this.goodsSid = goodsSid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getComGoodsSid() {
		return comGoodsSid;
	}

	public void setComGoodsSid(String comGoodsSid) {
		this.comGoodsSid = comGoodsSid;
	}

	public String getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

}
