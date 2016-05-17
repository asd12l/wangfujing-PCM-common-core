package com.wangfj.core.framework.base.vo;

import java.io.Serializable;

public class BaseVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer start;
    private Integer limit;
	/**
	 * @Return the Integer start
	 */
	public Integer getStart() {
		return start;
	}
	/**
	 * @Param Integer start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}
	/**
	 * @Return the Integer limit
	 */
	public Integer getLimit() {
		return limit;
	}
	/**
	 * @Param Integer limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
