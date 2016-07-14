/**
 * @Probject Name: common-core
 * @Path: com.wangfj.core.utilsSplitUtil.java
 * @Create By kong
 * @Create In 2015年10月27日 下午12:10:15
 *
 */
package com.wangfj.core.utils;

import com.wangfj.core.constants.ComErrorCodeConstants.ErrorCode;
import com.wangfj.core.constants.ComErrorCodeConstants.ExcptionTypeCode;
import com.wangfj.core.constants.ErrorCodeConstants;
import com.wangfj.core.framework.exception.BleException;
import com.wfj.exception.client.common.ErrorLevel;
import com.wfj.exception.client.handler.MyExceptionHandler;

/**
 * @Comment
 * @Class Name SplitUtil
 * @Author kong
 * @Create In 2015年10月27日
 */
public class ThrowExcetpionUtil {
	public static void splitExcetpion(BleException e){
		try {
			String[] strArr=splitCode(((BleException) e).getCode());
			boolean flag = ErrorCodeConstants.ErrorCode.vaildErrorCode(e.getCode());
			throw new MyExceptionHandler(strArr[0], ExcptionTypeCode.getErrorCodeName(strArr[0]), strArr[1], ((BleException) e).getMessage(), e, flag?ErrorLevel.ERROR.getCode():ErrorLevel.WARING.getCode());
		} catch (MyExceptionHandler e1) {
//			e1.printStackTrace();
		}
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
