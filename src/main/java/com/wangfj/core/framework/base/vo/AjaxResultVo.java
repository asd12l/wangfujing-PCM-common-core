/**
 * SUNING APPLIANCE CHAINS.
 * Copyright (c) 2013-2013 All Rights Reserved.
 */
package com.wangfj.core.framework.base.vo;

import java.io.Serializable;

/**
 * 
 * ajax调用结果 View Object
 * 
 * @author 张杰 88213565
 */

public class AjaxResultVo implements Serializable {

    private static final long serialVersionUID = -8035561823836882206L;

    // private String returnCode = "0";

    /** 失败信息 */
    // private String returnMsg = "成功";

    private boolean success = true;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
