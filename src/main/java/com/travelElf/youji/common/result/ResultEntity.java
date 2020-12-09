package com.travelElf.youji.common.result;

import com.travelElf.youji.common.util.ResourcesUtil;

import java.io.Serializable;

public class ResultEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String message;
    private T data;

    public ResultEntity(String errorCode, String message, T data) {
        super();
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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

    public  static<T>  ResultEntity<T> createSuccessResult(T data){
        ResultEntity<T> resultEntity = new ResultEntity<T>("0","成功",data);
        return resultEntity;
    }

    public  static<T> ResultEntity<T> createFailResult(Integer errorCode){
        ResultEntity<T> resultEntity = new ResultEntity<T>(String.valueOf(errorCode), ResourcesUtil.getMessageByCode(errorCode),null);
        return resultEntity;
    }
}
