package com.example.backend.constant;

import com.example.backend.common.ApiResponse;

public enum BusinessResponseCode implements ApiResponse {
    ID_NOT_FOUND("400", "ID_NOT_FOUND","Khong tim thay id");

    private String code;
    private String error;
    private String message;

    BusinessResponseCode(String code, String error, String message){
        this.code = code;
        this.error = error;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
