/**
 * @Probject Name: 00_product_business
 * @Path: com.bailian.core.framework.exceptionGenericResult.java
 * @Create By wangfei
 * @Create In 2014年9月28日 下午4:49:13
 *
 */
package com.wangfj.core.framework.exception;

/**
 * 泛型结果类<br>
 * 可返回指定类型的结果
 * 
 * @param <T>
 * @Class Name GenericResult
 * @Author wangfei
 * @Create In 2014年9月28日
 */
public class GenericResult<T> extends Result {
    private static final long serialVersionUID = 6884388024939222192L;

    /** 结果对象 */
    protected T object;

    /**
     * 获取结果对象
     * 
     * @return 结果对象
     */
    public T getObject() {
        return object;
    }

    /**
     * 设置结果对象
     * 
     * @param object
     *            结果对象
     */
    public void setObject(T object) {
        this.object = object;
    }
}
