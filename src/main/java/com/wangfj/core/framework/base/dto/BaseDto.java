package com.wangfj.core.framework.base.dto;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BaseDto implements Serializable{
	private static final long serialVersionUID = 1L;

}
