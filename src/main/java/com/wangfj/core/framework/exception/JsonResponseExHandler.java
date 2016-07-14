/**
 * @Probject Name: 00_product_common
 * @Path: com.bailian.core.framework.exceptionMyExceptionHandle.java
 * @Create By wangfei
 * @Create In 2014年9月28日 下午6:30:58
 *
 */
package com.wangfj.core.framework.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wangfj.core.constants.ComErrorCodeConstants;

/**
 * @Class Name MyExceptionHandle
 * @Author wangfei
 * @Create In 2014年9月28日
 */
public class JsonResponseExHandler implements HandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ExceptionLog.class);

    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        LOGGER.error("controller调用异常，{}", ex);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("success", "false");
        // 根据不同错误转向不同页面
        if (ex instanceof BleException) {
            model.put("errorCode", ((BleException) ex).getCode());
            model.put("memo", ((BleException) ex).getMessage());
        } else {
            model.put("errorCode",
                    ComErrorCodeConstants.ErrorCode.SYSTEM_ERROR.getErrorCode());
            model.put("memo",
                    ComErrorCodeConstants.ErrorCode.SYSTEM_ERROR.getMemo());
        }
        return new ModelAndView("exception/jsonResponse", model);
    }
}
