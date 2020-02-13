package com.china.myshop.commons.dto;

import java.io.Serializable;

/**
 * @ClassName: BaseResult
 * @Description: 自定义返回结果对象
 * @author: china wu
 * @date: 2019\9\9 0009 22:46
 */
public class BaseResult implements Serializable {

    public static final int STATUS_SUCCESS = 200;

    public static final int STATUS_FAIL = 500;

    /**
     * 响应状态码
     */
    private int statusCode;

    /**
     * 消息
     */
    private String message;

    /**
     *
     */
    private Object data;

    public static BaseResult success() {
        return BaseResult.createBaseResult(STATUS_SUCCESS, "成功", null);
    }

    public static BaseResult success(String message) {
        return BaseResult.createBaseResult(STATUS_SUCCESS, message, null);
    }

    public static BaseResult success(String message, Object data) {
        return BaseResult.createBaseResult(STATUS_SUCCESS, message, data);
    }

    public static BaseResult fail() {
        return BaseResult.createBaseResult(STATUS_FAIL, "失败", null);
    }

    public static BaseResult fail(String message) {
        return BaseResult.createBaseResult(STATUS_FAIL, message, null);
    }

    public static BaseResult fail(int statusCode, String message) {
        return BaseResult.createBaseResult(statusCode, message, null);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResult createBaseResult(int statusCode, String message, Object data) {
        BaseResult result = new BaseResult();
        result.setStatusCode(statusCode);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
