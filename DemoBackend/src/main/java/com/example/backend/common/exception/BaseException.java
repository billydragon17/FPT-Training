package com.example.backend.common.exception;


import com.example.backend.common.ApiResponse;

public class BaseException extends RuntimeException {
    protected String code;
    protected String error;
    protected String message;

    public BaseException() {
    }

    public BaseException(String code, String error, String message) {
        this.error = error;
        this.code = code;
        this.message = message;
    }

    public BaseException(ApiResponse response){
        this.code = response.getCode();
        this.message = response.getMessage();
        this.error = response.getError();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
