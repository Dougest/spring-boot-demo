package com.hola.util;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class JsonResult<T> implements Serializable{
    private Integer stateCode;

    private String message;

    private T data;

    private Boolean flag;

    private Object object;

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public JsonResult(Integer stateCode, String message, T data, Boolean flag, Object object) {
        this.stateCode = stateCode;
        this.message = message;
        this.data = data;
        this.flag = flag;
        this.object = object;
    }
    public JsonResult(){}

    @Override
    public String toString() {
        return "JsonResutl{" +
                "stateCode=" + stateCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", flag=" + flag +
                ", object=" + object +
                '}';
    }
}
